package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadFive implements Runnable{
    private  Integer lock;

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

/* public void run() {
        try {

            Thread.currentThread().interrupt();

            //TimeUnit.SECONDS.sleep(1);

            if (Thread.currentThread().isInterrupted()){
                Thread.yield();
            }

            System.out.println(Thread.currentThread()+"执行");
            //TimeUnit.SECONDS.sleep(10);


            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("666888");
        }
    }*/

/*    private MyThreadFour myThreadFour;

    public MyThreadFive(String name, MyThreadFour myThreadFour) {
        super(name);
        this.myThreadFour = myThreadFour;
        start();
    }

    @Override
    public void run() {

        try {
            System.out.println(myThreadFour.getState());
            myThreadFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName()+" join completed");
    }*/

    private MyIntGenerator myIntGenerator;

    public MyThreadFive() {
    }

    public MyThreadFive(Integer lock, MyIntGenerator myIntGenerator) {
        this.lock = lock;
        this.myIntGenerator = myIntGenerator;
    }

    public MyThreadFive(MyIntGenerator myIntGenerator) {
        this.myIntGenerator = myIntGenerator;
    }

    public void run() {
        //throw new RuntimeException();
        //int i = 1 / 0;
        //System.out.println(Thread.currentThread().getName()+"守护线程执行中");

        try {
           System.out.println(Thread.currentThread().getName()+",888888开始操作");
            //myIntGenerator.next();
           // MyIntGenerator.last();
           //myIntGenerator.mid();
           //myIntGenerator.first();
           // myIntGenerator.second();
            //synchronized (lock){
                myIntGenerator.five(lock);
           // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
