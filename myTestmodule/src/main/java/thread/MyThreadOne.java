package thread;


public class MyThreadOne extends Thread{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MyThreadOne() {
        super();
    }

    public MyThreadOne(Runnable target) {
        super(target);
    }

    public MyThreadOne(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThreadOne(String name) {
        super(name);
    }

    public MyThreadOne(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThreadOne(Runnable target, String name) {
        super(target, name);
    }

    public MyThreadOne(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThreadOne(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        System.out.println("我是线程一号:"+Thread.currentThread().getName());

        for (int i = 0;i < 5;i++) {
//            try{
//                if (i == 3){
//
//                        System.out.println(Thread.currentThread().getName()+"我是线程一号，有点累，想休息一下，你们先去吧");
//                        Thread.sleep(1000);
//
//                }else if (i == 1){
//                    int j = 1/0;
//                }
//            }catch (Exception e){
//                System.out.println("捕捉线程异常888666："+e.getMessage());
//            }

            //MyUtils.test1();

       }
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }

    @Override
    public boolean isInterrupted() {
        return super.isInterrupted();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public int countStackFrames() {
        return super.countStackFrames();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ClassLoader getContextClassLoader() {
        return super.getContextClassLoader();
    }

    @Override
    public void setContextClassLoader(ClassLoader cl) {
        super.setContextClassLoader(cl);
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public State getState() {
        return super.getState();
    }

    @Override
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return super.getUncaughtExceptionHandler();
    }

    @Override
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler eh) {
        super.setUncaughtExceptionHandler(eh);
    }
}
