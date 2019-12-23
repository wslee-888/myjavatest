package thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

//面包
class Toast{
    public enum Status {DRY,BUTTED,JAMMED,JELLYED}
    private Status status = Status.DRY;
    private int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter(){
        status = Status.BUTTED;
    }

    public void jam(){
        status = Status.JAMMED;
    }

    public void jelly(){
        status = Status.JELLYED;
    }

    public Status getStatus(){
        return status;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast>{
}

//生产吐司
class Toaster implements Runnable{
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));

                Toast toast = new Toast(count++);
                System.out.println(toast);

                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }

        System.out.println("Toaster off");
    }
}

//抹黄油
class Butter implements Runnable{
    private ToastQueue dryQueue, butterQueue;

    public Butter(ToastQueue dryQueue, ToastQueue butterQueue) {
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butterQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Butter interrupted");
        }

        System.out.println("Butter off");
    }
}

//涂果酱
class Jammer implements Runnable{
    private ToastQueue butterQueue, finishedQueue;

    public Jammer(ToastQueue butterQueue, ToastQueue finishedQueue) {
        this.butterQueue = butterQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()){
                Toast toast = butterQueue.take();
                toast.jam();
                System.out.println(toast);
                finishedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }

        System.out.println("Jammer Off");
    }
}

class Jellyer implements Runnable{
    private ToastQueue dryQueue,finishedQueue;

    public Jellyer(ToastQueue dryQueue,ToastQueue finishedQueue) {
        this.dryQueue = dryQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast = dryQueue.take();
                toast.jelly();
                finishedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jelly interrupted");
        }

        System.out.println("Jelly Off");
    }
}

//消费吐司
class Eater implements Runnable{
    private ToastQueue finishQueue;
    private int counter;

    public Eater(ToastQueue finishQueue) {
        this.finishQueue = finishQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast = finishQueue.take();

                if (toast.getId() != counter++ || (toast.getStatus() != Toast.Status.JAMMED && toast.getStatus() != Toast.Status.JELLYED)){
                    System.out.println(">>>>>> Error: " + toast);
                }else{
                    System.out.println("Chomp " + toast);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }

        System.out.println("Eater Off");
    }
}

public class ToastMatic {

    public static void main(String[] args) throws Exception{
        ToastQueue dryQueue = new ToastQueue(),
                   butterQueue = new ToastQueue(),
                   finishedQueue = new ToastQueue();

        ExecutorService exce = Executors.newCachedThreadPool();
        exce.execute(new Toaster(dryQueue));
        exce.execute(new Butter(dryQueue,butterQueue));
        exce.execute(new Jammer(butterQueue,finishedQueue));
        exce.execute(new Jellyer(dryQueue,finishedQueue));
        exce.execute(new Eater(finishedQueue));

        TimeUnit.SECONDS.sleep(5);
        exce.shutdownNow();
    }
}
