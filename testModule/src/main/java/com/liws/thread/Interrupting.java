package com.liws.thread;


import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable{
    public void run() {
        System.out.println("进入SleepBlocked");

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Sleep InterruptedException");
        }

        System.out.println("Exiting SleepBlocked.run()");
    }
}

class  waitBlocked implements Runnable{
    public void run() {

    }
}

class IOBlocked implements Runnable{
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            System.out.println("Waiting for read(): ");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked I/O");
            }else{
                throw new RuntimeException();
            }
        }

        System.out.println("Exiting IOBlocked.run()");
    }
}

class synchronizedBlocked implements Runnable{
    public synchronized void f(){
        while (true){
            //从不释放锁
            Thread.yield();
        }
    }

    public synchronizedBlocked() {

        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();

    }

    public void run() {

        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting synchronizedBlocked.run()");
    }
}



public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupted " + r.getClass().getName());

        f.cancel(true);//执行中断权限
        System.out.println("Interrupted sent to "+r.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
        //test(new SleepBlocked());
        //test(new IOBlocked(System.in));
        test(new synchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);

        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }

}
