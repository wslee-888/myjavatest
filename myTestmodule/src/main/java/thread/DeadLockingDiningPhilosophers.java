package thread;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Choptick2{
    private boolean taken = false;

    public synchronized void taken() throws InterruptedException{
        while (taken){
            wait();
        }
        taken = true;
    }

    public synchronized void drop(){
        taken = false;
        notifyAll();
    }
}


class Philosopher2 implements Runnable{
    private Choptick2 left;
    private Choptick2 rigth;
    private int id;
    private int pomderFactor;
    private Random random = new Random(47);

    private void pause() throws InterruptedException{
        if (pomderFactor == 0){
            return;
        }
        TimeUnit.MILLISECONDS.sleep(random.nextInt(pomderFactor * 250));
    }

    public Philosopher2(Choptick2 left, Choptick2 rigth, int id, int pomderFactor) {
        this.left = left;
        this.rigth = rigth;
        this.id = id;
        this.pomderFactor = pomderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println(this + "  " + "thinking");
                pause();

                System.out.println(this + "  " + "grabbing right");
                rigth.taken();

                System.out.println(this + "  " + "grabbing left");
                left.taken();

                System.out.println(this + "  " + "eating");
                pause();

                rigth.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + "  " + "exiting via interrupt");        }
    }

    @Override
    public String toString() {
        return "Philosopher2 " + id;
    }
}

public class DeadLockingDiningPhilosophers {

    public static void main(String[] args) throws Exception{

        int ponder = 5;
//        if (args.length > 0){
//            ponder = Integer.parseInt(args[0]);
//        }

        int size = 5;
//        if (args.length > 1){
//            size = Integer.parseInt(args[1]);
//        }

       ExecutorService exce = Executors.newCachedThreadPool();
       Choptick2[] sticks = new Choptick2[size];

       for (int i = 0; i < size; i++){
           sticks[i] = new Choptick2();
       }

       for (int i = 0; i < size; i++){
           exce.execute(new Philosopher2(sticks[i],sticks[(i+1) % size], i, ponder));
       }

       //if (args.length == 3 && args[2].equals("timeOut")){
           TimeUnit.SECONDS.sleep(5);
       //}else{
          // System.out.println("Press 'Enter' to quit");
           //System.in.read();
       //}

       //exce.shutdownNow();


    }

}


//        Philosopher2 0  thinking
//        Philosopher2 1  thinking
//        Philosopher2 2  thinking
//        Philosopher2 3  thinking
//        Philosopher2 4  thinking
//        Philosopher2 0  grabbing right
//        Philosopher2 2  grabbing right
//        Philosopher2 3  grabbing right
//        Philosopher2 4  grabbing right
//        Philosopher2 1  grabbing right
//        Philosopher2 1  grabbing left
//        Philosopher2 4  grabbing left
//        Philosopher2 3  grabbing left
//        Philosopher2 2  grabbing left
//        Philosopher2 0  grabbing left



