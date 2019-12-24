import com.liws.other.otherBean.MyUncaughtExceptionHandler;
import com.liws.thread.*;

import java.util.concurrent.*;

public class MyThreadTest {
    public static String str = "123";

    public static void main(String[] args) throws Exception {

/*        System.out.println("我是主线程："+Thread.currentThread().getName());


        //方式一
        try{
            MyThreadOne t1 = new MyThreadOne();
            t1.start();
            t1.join();
            //System.out.println("id:"+t1.getId());


            //在某个线程里，捕捉另外一个线程,如在主线程里捕捉其他线程的异常
//            t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//                public void uncaughtException(Thread t, Throwable e) {
//                    System.out.println("正确捕捉线程异常："+e.getMessage());
//                }
//            });

        }catch (Exception e){
            System.out.println("无法捕捉线程的异常："+e.getMessage());
        }*/



//        t1.destroy();

        //方式二

        //synchronized (str){
           // MyThreadTwo threadTwo = new MyThreadTwo();
            //Thread t2 = new Thread(threadTwo);

            //str.wait(1000);
        //}


        //方式三
        //Callable threadThree = new MyThreadThree();
        //FutureTask futureTask = new FutureTask(threadThree);
        //Thread t3 = new Thread(futureTask);
//        t3.start();
//
//        System.out.println("futureTask:"+futureTask.isDone());
//        Integer i = (Integer) futureTask.get();
//        System.out.println("futureTask result:"+i);

        //方式四
        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        //MyThreadFour threadFour = new MyThreadFour();

        //executorService.execute(threadFour);

        //关闭线程池
        //executorService.shutdown();

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future future = executorService.submit(threadThree);
//        System.out.println("future:"+future.isDone());//是否阻塞

        //t1.start();
        //t2.start();
        //t3.start();


/*        try {

           MyThreadTwo threadTwo = new MyThreadTwo();
           for (int i = 10 ; i>0 ; i--) {

               Thread thread = new Thread(threadTwo);

               if (i%2 == 0){
                   thread.setName(thread.getName()+"你瞅啥");
               }else{
                   thread.setName(thread.getName()+"瞅你咋了");
               }


               thread.start();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


//        Thread thread = new Thread(new MyThreadTwo());
//        thread.setDaemon(true);//线程守护
//
//        thread.start();
//
//        //TimeUnit.MILLISECONDS.sleep(170);
//        System.out.println("结束888888");

      /*  Thread thread = new Thread(new MyThreadFive());
        thread.setDaemon(true);
        thread.start();*/

/*        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
        // 获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slackList);
        // copy into a list that is the exact size
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        System.out.println("Thread list size == " + list.length);
        for (Thread thread : list) {
            System.out.println(thread.getName());
        }*/

       /* Thread thread = new Thread(new MyThreadFive(),"112233");
        thread.start();
        thread.join();

        System.out.println("主线程执行");*/

/*       MyThreadFour myThreadFour1 = new MyThreadFour("myThreadFour1",1500);
       MyThreadFour myThreadFour2 = new MyThreadFour("myThreadFour2",1500);

       MyThreadFive myThreadFive1 = new MyThreadFive("myThreadFive1",myThreadFour1);
       MyThreadFive myThreadFive2 = new MyThreadFive("myThreadFive2",myThreadFour2);

       myThreadFour2.interrupt();*/

     /*   new MyThreadFour();
        System.in.read();
        System.out.println(MyThreadFour.d);*/


        //ExecutorService executorService = Executors.newCachedThreadPool();
       // executorService.execute(new MyThreadFive());

/*        Thread thread = new Thread(new MyThreadFive());
        thread.start();
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());*/


        //MyThreadFour myThreadFour = new MyThreadFour();
        //myThreadFour.start();

       /* ExecutorService executorService = Executors.newFixedThreadPool(10);
        MyIntGenerator myIntGenerator = new MyIntGenerator();
        executorService.execute(new MyThreadFive(myIntGenerator));

        executorService.shutdown();*/
        MyIntGenerator myIntGenerator = new MyIntGenerator();
        Integer lock = 8;
        for (int i = 0; i < 1000 ;i++){

          /*  if (i%2 == 0){
                Thread thread = new Thread(new MyThreadFive(myIntGenerator));
                //System.out.println("线程组名66666："+thread.getThreadGroup().getName());
                thread.start();
            }else{
                Thread thread = new Thread(new MyThreadTwo(myIntGenerator));
                //System.out.println("线程组名88888："+thread.getThreadGroup().getName());
                thread.start();
            }*/

            //Thread thread = new Thread(new MyThreadFive(i,myIntGenerator));
            //thread.start();

            if (i%2 == 0){
                Thread thread = new Thread(new MyThreadFive(lock,myIntGenerator));
                //System.out.println("线程组名66666："+thread.getThreadGroup().getName());
                thread.start();
            }else{
                Thread thread = new Thread(new MyThreadTwo(lock,myIntGenerator));
                //System.out.println("线程组名88888："+thread.getThreadGroup().getName());
                thread.start();
            }


        }

/*        t3.interrupt();//设置中断
        t3.isAlive();//判断当前线程是否处于活动状态。活动状态就是线程启动且尚未终止，比如正在运行或准备开始运行。
        t3.getStackTrace();//返回一个栈轨迹元素的数组
        t3.setContextClassLoader(null);//线程上下文类加载器
        t3.setName(null);
        t3.getName();
        t3.getId();
        t3.getThreadGroup();//获取所属的线程组
        t3.getState();//获取状态
        t3.wait(1000);
        t3.notify();
        t3.notifyAll();
        t3.join(1000);
        t3.setPriority(10);
        t3.interrupt();
        t3.getContextClassLoader();
        t3.checkAccess();//判定当前运行的线程是否有权修改该线程。
        t3.setDaemon(true);
        t3.setUncaughtExceptionHandler(null);

        Thread.sleep(1000,200);//线程睡眠 millis 毫秒 + nanos 纳秒
        TimeUnit.SECONDS.sleep(1000);
        Thread.interrupted();
        Thread.currentThread();
        Thread.yield();
        //Thread.UncaughtExceptionHandler //t3.setUncaughtExceptionHandler(null);
        Thread.activeCount();//返回活动线程的当前线程的线程组中的数量
        Thread.dumpStack();//方法将当前线程的堆栈跟踪打印到标准错误流。它仅用于调试。
        Thread.enumerate();//复制该线程组及其子组中的所有活动线程到指定的数组
        Thread.getAllStackTraces();
        Thread.setDefaultUncaughtExceptionHandler();
        Thread.holdsLock();//返回true如果当且仅当当前线程拥有某个具体对象的锁*/
    }
}
