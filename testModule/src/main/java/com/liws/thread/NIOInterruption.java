package com.liws.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NIOBlocked implements Runnable{
    private SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("Waiting for read() in " + this);
        try {
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e){
            System.out.println("ClosedByInterruptException");
        }catch (AsynchronousCloseException e){
            System.out.println("AsynchronousCloseException");
        }catch (IOException e) {
            throw new RuntimeException();
        }
    }

}

public class NIOInterruption {

    public static void main(String[] args) throws Exception{
        ExecutorService exce = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(8880);

        InetSocketAddress isa = new InetSocketAddress("localhost",8880);

        SocketChannel sc1 = SocketChannel.open(isa);

        SocketChannel sc2 = SocketChannel.open(isa);

        Future<?> f = exce.submit(new NIOBlocked(sc1));

        exce.execute(new NIOBlocked(sc2));

        exce.shutdown();

        TimeUnit.SECONDS.sleep(1);

        f.cancel(true);

        TimeUnit.SECONDS.sleep(1);

        sc2.close();
    }

}
