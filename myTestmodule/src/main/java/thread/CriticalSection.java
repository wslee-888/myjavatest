package thread;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair{
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0,0);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void incrementX(){
        x++;
    }

    public void incrementY(){
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValueNotEqualException extends RuntimeException{
        public PairValueNotEqualException() {
            super("Pair value not equal: "+Pair.this);
        }
    }

    public void checkState(){
        if (x != y){
          throw new PairValueNotEqualException();
        }
    }
}

abstract class PairManeger{
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair(){
        return new Pair(p.getX(), p.getY());
    }
    protected void store(Pair p){
        storage.add(p);

        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public abstract void increment();

}

class PairManager1 extends PairManeger{
    @Override
    public void increment() {
      p.incrementX();
      p.incrementY();
      store(getPair());
    }
}

class PairManager2 extends PairManeger{

    @Override
    public void increment() {
        Pair temp;

        synchronized (this){
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }

        store(temp);
    }
}

class PairManaPulator implements Runnable{
    private PairManeger pm;

    public PairManaPulator(PairManeger pm) {
        this.pm = pm;
    }

    public void run() {
        while (true){
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable{
    private PairManeger pm;

    public PairChecker(PairManeger pm) {
        this.pm = pm;
    }

    public void run() {
        while (true){
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}


public class CriticalSection {
    static void testApproaches(PairManeger p1, PairManeger p2){
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManaPulator pm1 = new PairManaPulator(p1);
        PairManaPulator pm2 = new PairManaPulator(p2);


        PairChecker pchecker1 = new PairChecker(p1);
        PairChecker pchecker2 = new PairChecker(p2);

        executorService.execute(pm1);
        executorService.execute(pm2);

        executorService.execute(pchecker1);
        executorService.execute(pchecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }

        System.exit(0);
    }

    public static void main(String[] args) {
       PairManeger pmg1 = new PairManager1();
       PairManeger pmg2 = new PairManager2();


       testApproaches(pmg1, pmg2);
    }
}
