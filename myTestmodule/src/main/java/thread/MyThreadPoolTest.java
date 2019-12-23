package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolTest {

    public static void main(String[] args) throws Exception{
        //列举一下常用的线程池
        //ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
       // ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        //定时作业的线程池
        //ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);

        ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(1, 2,
                10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        MyIntGenerator myIntGenerator = new MyIntGenerator();
        myThreadPool.execute(new MyThreadTwo(myIntGenerator));

        TimeUnit.SECONDS.sleep(10);

        //BlockingQueue<Runnable> queue = myThreadPool.getQueue();
       //queue.add(new MyThreadTwo(myIntGenerator));

        myThreadPool.execute(new MyThreadTwo(myIntGenerator));
    }
}
