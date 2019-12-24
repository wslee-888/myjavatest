package com.liws.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//菜品
class Meal{

    private int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal "+orderNum;
    }
}

//服务员
class WaitPerson implements Runnable{
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                   while (restaurant.meal == null){
                       System.out.println("666666");
                       wait();
                   }
                }

                System.out.println("WaitPeson got " + restaurant.meal);

                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

//厨师
class Chef implements Runnable{
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {

        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal != null){
                        System.out.println("888888");
                        wait();
                    }
                }

                if (++count == 10){
                    System.out.println("Out of food, closing");
                    restaurant.exce.shutdownNow();
                }

                System.out.println("Order up!");

                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }

                //TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }


    }
}

//餐馆
public class Restaurant {
    Meal meal;

    ExecutorService exce = Executors.newCachedThreadPool();

    Chef chef = new Chef(this);

    WaitPerson waitPerson = new WaitPerson(this);

    public Restaurant() {
        exce.execute(chef);
        exce.execute(waitPerson);
    }

    public static void main(String[] args) {
       new Restaurant();
    }
}
