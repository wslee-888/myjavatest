package thread;

public class MyThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("我的线程组");
        threadGroup.setDaemon(true);

        Thread thread = new Thread(threadGroup, new MyThreadTwo());
        System.out.println(thread.getThreadGroup().getName());

        //threadGroup.setDaemon(true);
        System.out.println(thread.isDaemon());

       /* ThreadGroup parentgroup = threadGroup.getParent();
        System.out.println(parentgroup.getName());

        ThreadGroup rootparentgroup =  parentgroup.getParent();
        System.out.println(rootparentgroup.getName());*/
    }
}
