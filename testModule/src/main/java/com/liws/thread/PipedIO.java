package com.liws.thread;

import ch.qos.logback.core.util.TimeUtil;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable{
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {

        try {
            //while (true){
                for (char c = 'A'; c <= 'Z'; c++){
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            //}
        } catch (IOException e) {
            System.out.println("Sender write exception");
        } catch (InterruptedException e) {
            System.out.println("Sender interrupted");
        }

    }
}

class Receiver implements Runnable{
    private PipedReader in;

    public Receiver(Sender sender) throws IOException{
        this.in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println("666666:"+Thread.currentThread().getState());
                System.out.println("Read: " + (char)in.read() + ",");
                System.out.println("888888:"+Thread.currentThread().getState());
            }
        } catch (IOException e) {
            System.out.println("Receiver read exception");
        }
    }
}


public class PipedIO {
    public static void main(String[] args) throws Exception{
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);

        ExecutorService exce = Executors.newCachedThreadPool();
        exce.execute(sender);
        exce.execute(receiver);

        TimeUnit.SECONDS.sleep(60);
        exce.shutdownNow();
    }
}
