package com.liws.thread;

import java.util.concurrent.TimeUnit;

class NeedsCleanUp{
    private int id;

    public NeedsCleanUp(int id) {
        this.id = id;
        System.out.println("NeedsCleanUp " + id);
    }

    public void clean(){
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable{
    private volatile double d = 0.0;
    public void run() {

        try {
            while (!Thread.interrupted()){
                NeedsCleanUp n1 = new NeedsCleanUp(1);

                try {
                    //System.out.println("Sleeping");
                    //TimeUnit.SECONDS.sleep(1);

                    NeedsCleanUp n2 = new NeedsCleanUp(2);

                    try {
                        System.out.println("calculating");
                        for (int i = 1; i < 2588008; i++){
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming operation");
                    } finally {
                         n2.clean();
                    }
                } finally {
                    n1.clean();
                }
            }
        } /*catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
            e.printStackTrace();
        }*/
        finally {

        }
    }
}

public class InterruptingIdion {
    public static void main(String[] args) throws Exception{
        /*if (args.length != 1){
            System.out.println("usage: java InterruptingIdion delay-in-ms");
            System.exit(1);
        }*/
        Thread thread = new Thread(new Blocked3());
        thread.start();

        TimeUnit.SECONDS.sleep(2);

        System.out.println("主线程执行中断指令");
        thread.interrupt();
    }

/*    NeedsCleanUp 1
    Sleeping
    NeedsCleanUp 2
    calculating
    Finished time-consuming operation
    Cleaning up 2
    Cleaning up 1
    NeedsCleanUp 1
    Sleeping
            主线程执行中断指令
    Cleaning up 1
    Exiting via InterruptedException*/
}
