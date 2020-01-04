package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutek{
    private Lock lock = new ReentrantLock();

    public BlockedMutek() {
        lock.lock();
    }

    public void f(){
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("Interrupted from lock acquired in f()");
        }
    }
}

class Blocked2 implements Runnable{
    BlockedMutek blockedMutek = new BlockedMutek();
    public void run() {
        System.out.println("Waiting for f() in blockedMutek");
        blockedMutek.f();
        System.out.println("Broken out of blocked call");
    }
}

public class LockBlocked{
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Blocked2());
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing thread.interrupted");

        thread.interrupt();
    }
}

