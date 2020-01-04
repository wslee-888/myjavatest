package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

class LiftOff{

    public void run(){

    }

}

class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        this.rockets = queue;
    }

    public void add(LiftOff liftOff){
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()){
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("waiting from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}


public class TestBlockQueues {
    static void getKey(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message){
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue){
        System.out.println(msg);

        LiftOffRunner runner = new LiftOffRunner(queue);

        Thread thread = new Thread(runner);

        thread.start();

        for (int i = 0; i < 5; i++){
            runner.add(new LiftOff());
        }

        getKey("Press Enter (" + msg + ")");

        thread.interrupt();

        System.out.println("Finishing " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",new SynchronousQueue<LiftOff>());
    }

}
