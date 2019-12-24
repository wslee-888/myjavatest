package com.liws.thread;

import java.util.concurrent.TimeUnit;

public class MyThreadTwo implements Runnable {
    private Integer lock;
    private MyIntGenerator myIntGenerator;

    public MyThreadTwo() {
    }

    public MyThreadTwo(MyIntGenerator myIntGenerator) {
        this.myIntGenerator = myIntGenerator;
    }

    public MyThreadTwo(Integer lock, MyIntGenerator myIntGenerator) {
        this.lock = lock;
        this.myIntGenerator = myIntGenerator;
    }

    public void run() {

       try {
          /* for (int i = 1;i<10;i++){
               //Thread thread = new Thread(new MyThreadFive());
               //thread.start();
           }

           while (true){
               Thread.yield();
           }*/

           try {
               System.out.println(Thread.currentThread().getName()+",666666开始操作");
               // myIntGenerator.next();
               // MyIntGenerator.last();
               //myIntGenerator.mid();
               // myIntGenerator.first();
               // myIntGenerator.second();
               //myIntGenerator.third();
               myIntGenerator.six(lock);
           } catch (Exception e) {
               e.printStackTrace();
           }

       }catch (Exception e){
           e.printStackTrace();
       }



    }
}
