package com.liws.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
    private boolean waxOn = false;

    //隐式锁
    public synchronized void waxed(){
        System.out.println("打蜡");
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed(){
        System.out.println("抛光");
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException{
        System.out.println("进入waitForWaxing");
        if (waxOn == false){
            System.out.println("等待打蜡"+waxOn);
            wait();
        }
    }

    public synchronized void waitForBuffing()throws InterruptedException{
        System.out.println("进入waitForBuffing");
        if (waxOn == true){
            System.out.println("等待抛光"+waxOn);
            wait();
        }
    }


}

class WaxOn implements Runnable{
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Wax On task");
        }
    }
}

class Waxoff implements Runnable{
    private Car car;

    public Waxoff(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("66666");
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Wax Off task");
        }
    }
    /*final void f(){

    }*/
}




public class WaxOMatic {

    public static void main(String[] args) throws Exception{
        Car car = new Car();

        ExecutorService exce = Executors.newCachedThreadPool();
        exce.execute(new Waxoff(car));
        exce.execute(new WaxOn(car));

        TimeUnit.SECONDS.sleep(3);
        exce.shutdownNow();
    }

}
