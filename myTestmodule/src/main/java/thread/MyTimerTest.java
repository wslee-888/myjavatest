package thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTimerTest {

    public static void main(String[] args) throws Exception{
        //一般线程,结合基本的睡眠，等待来直接实现定时作业
        //Thread.sleep(1000);

        //Timer单线程实现定时作业
  /*      TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("单线程定时作业timer99666");
            }
        };

        Timer timer = new Timer();
        //timer.schedule(timerTask,10000);
        //timer.schedule(timerTask,new Date());
        //timer.schedule(timerTask,1000,1000);
        //timer.schedule(timerTask,new Date(),1000);
        //timer.scheduleAtFixedRate(timerTask,1000,1000);
        timer.scheduleAtFixedRate(timerTask,new Date(), 1000);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();*/

        //ScheduledThreadPoolExecutor线程池实现定时作业
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        //ExecutorService scheduledThreadPoolExecutor = Executors.newScheduledThreadPool(10);

        MyIntGenerator myIntGenerator = new MyIntGenerator();
        //scheduledThreadPoolExecutor.execute(new MyThreadTwo(myIntGenerator));

        //scheduledThreadPoolExecutor.schedule(new MyThreadTwo(myIntGenerator),10, TimeUnit.SECONDS);

        //scheduledThreadPoolExecutor.schedule(new MyThreadThree(),8,TimeUnit.SECONDS);

        //scheduledThreadPoolExecutor.scheduleAtFixedRate(new MyThreadTwo(myIntGenerator),2000,1000, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new MyThreadTwo(myIntGenerator), 2000, 1000, TimeUnit.MILLISECONDS);

        //TimeUnit.SECONDS.sleep(5);

        //scheduledThreadPoolExecutor.shutdown();

        //利用高度封装的定时作业框架quarzt,spring等
    }

}
