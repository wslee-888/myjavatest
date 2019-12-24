package com.liws.thread;

public class MyThreadFour extends Thread{
   /* private int duration;

    public MyThreadFour(String name,int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName()+" was interrupted isInterrupted:"+isInterrupted());
            return;
        }

        System.out.println(getName()+" has awakened");
    }*/

    public static volatile int d = 1;

    public MyThreadFour() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true){
            d++ ;
        }
    }

/*    @Override
    public void run() {
        Thread threadFive =  new Thread(new MyThreadFive());
        threadFive.setDaemon(true);
        threadFive.start();

        while (true){
            System.out.println("守护线程状态："+threadFive.getState());
        }
    }*/
}
