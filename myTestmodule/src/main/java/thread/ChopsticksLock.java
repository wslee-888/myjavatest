package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 筷子死锁典型问题
 */
public class ChopsticksLock implements Runnable{
    private static String lockA = "A";
    private static String lockB = "B";
    private int i;

    public ChopsticksLock(int i) {
        this.i = i;
    }

    public void f(){
        try {
            synchronized (lockA){
                TimeUnit.MILLISECONDS.sleep(200);
                synchronized (lockB){
                    System.out.println("拿到A和B筷子了");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(){
        try {
            synchronized (lockB){
                TimeUnit.MILLISECONDS.sleep(200);
                synchronized (lockA){
                    System.out.println("拿到B和A筷子了");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (i%2 == 0){
            f();
        }else{
            g();
        }
    }

    public static void main(String[] args) {
        //ExecutorService exce = Executors.newCachedThreadPool();

        for (int i = 0; i < 2; i++){
            //exce.execute(new ChopsticksLock(i));
            new Thread(new ChopsticksLock(i)).start();
        }
    }

}


