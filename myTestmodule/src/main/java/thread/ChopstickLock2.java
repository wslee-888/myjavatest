package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Chopstick{
    private int id;
    private boolean taken = false;

    public Chopstick(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public synchronized boolean take(){
        boolean result = false;
        if (!taken){
            taken = true;
            result = true;
        }

        return result;
    }

    public synchronized void drop(){
        System.out.println("chopsticks id:" + id+",被放弃使用开始");
        taken = false;
        System.out.println("chopsticks id:" + id+",被放弃使用结束");
    }

}

class Philosopher implements Runnable{
    //private Chopstick left;
    //private Chopstick right;

    private int id;
    private List<Chopstick> chopstickList;
    private int count = 0;
    private List<Chopstick> chopsticks;


    public Philosopher(int id,List<Chopstick> chopstickList) {
        this.id = id;
        this.chopstickList = chopstickList;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){

                chopsticks = new ArrayList<>();
                String chopids = "";

                while (count < 2){
                    for (Chopstick chopstick:chopstickList){
                        if (count == 2){
                            break;
                        }

                        boolean result = chopstick.take();
                        if (result){
                            System.out.println("Philosopher id: "+id+",拥有筷子Chopstick id:"+chopstick.getId());

                            count++;
                            chopsticks.add(chopstick);
                            chopids += chopstick.getId()+"|";
                        }
                    }
                }


                System.out.println("id:"+id+",拥有的筷子ids: " + chopids + ", 数量："+count+",开始用餐");


                TimeUnit.MILLISECONDS.sleep(500);

                for (Chopstick chopstick:chopsticks){
                    chopstick.drop();
                }

                count = 0;

                System.out.println("id:"+id+",拥有的筷子ids: " + chopids +",结束用餐");

            }

            System.out.println("Philosopher id："+id+","+Thread.currentThread().getId()+",退出循环结束");

        } catch (InterruptedException e) {
            System.out.println("Philosopher id："+id+","+Thread.currentThread().getId()+",Interrupted");
        }finally {
            for (Chopstick chopstick:chopsticks){
                chopstick.drop();
            }

            count = 0;
        }

    }
}

public class ChopstickLock2 {

    public static void main(String[] args) throws Exception{
        List<Chopstick> chopstickList = new ArrayList<>();
        Chopstick chopstick = null;

        for (int i = 0; i < 5; i++){
            chopstick = new Chopstick(i);
            chopstickList.add(chopstick);
        }

        ExecutorService exce = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exce.execute(new Philosopher(i, chopstickList));
        }

        TimeUnit.SECONDS.sleep(8);

        exce.shutdownNow();
    }


//    Philosopher id: 0,拥有筷子Chopstick id:0
//    Philosopher id: 0,拥有筷子Chopstick id:1
//    id:0,拥有的筷子ids: 0|1|, 数量：2,开始用餐
//    Philosopher id: 1,拥有筷子Chopstick id:2
//    Philosopher id: 1,拥有筷子Chopstick id:3
//    Philosopher id: 2,拥有筷子Chopstick id:4
//    id:1,拥有的筷子ids: 2|3|, 数量：2,开始用餐
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    Philosopher id: 3,拥有筷子Chopstick id:0
//    Philosopher id: 4,拥有筷子Chopstick id:1
//    id:0,拥有的筷子ids: 0|1|,结束用餐
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    chopsticks id:3,被放弃使用开始
//    chopsticks id:3,被放弃使用结束
//    Philosopher id: 4,拥有筷子Chopstick id:2
//    id:1,拥有的筷子ids: 2|3|,结束用餐
//    Philosopher id: 3,拥有筷子Chopstick id:3
//    id:3,拥有的筷子ids: 0|3|, 数量：2,开始用餐
//    id:4,拥有的筷子ids: 1|2|, 数量：2,开始用餐
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    id:4,拥有的筷子ids: 1|2|,结束用餐
//    chopsticks id:0,被放弃使用结束
//    chopsticks id:3,被放弃使用开始
//    chopsticks id:3,被放弃使用结束
//    Philosopher id: 1,拥有筷子Chopstick id:0
//    Philosopher id: 2,拥有筷子Chopstick id:2
//    Philosopher id: 4,拥有筷子Chopstick id:1
//    id:2,拥有的筷子ids: 4|2|, 数量：2,开始用餐
//    id:3,拥有的筷子ids: 0|3|,结束用餐
//    Philosopher id: 0,拥有筷子Chopstick id:3
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    id:2,拥有的筷子ids: 4|2|,结束用餐
//    Philosopher id: 4,拥有筷子Chopstick id:2
//    Philosopher id: 2,拥有筷子Chopstick id:4
//    id:4,拥有的筷子ids: 1|2|, 数量：2,开始用餐
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    Philosopher id: 3,拥有筷子Chopstick id:1
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    Philosopher id: 3,拥有筷子Chopstick id:2
//    id:3,拥有的筷子ids: 1|2|, 数量：2,开始用餐
//    id:4,拥有的筷子ids: 1|2|,结束用餐
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    Philosopher id: 4,拥有筷子Chopstick id:1
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    id:3,拥有的筷子ids: 1|2|,结束用餐
//    Philosopher id: 4,拥有筷子Chopstick id:2
//    id:4,拥有的筷子ids: 1|2|, 数量：2,开始用餐
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    Philosopher id: 1,拥有筷子Chopstick id:1
//    id:1,拥有的筷子ids: 0|1|, 数量：2,开始用餐
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    Philosopher id: 3,拥有筷子Chopstick id:2
//    id:4,拥有的筷子ids: 1|2|,结束用餐
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    Philosopher id: 4,拥有筷子Chopstick id:0
//    Philosopher id: 0,拥有筷子Chopstick id:1
//    id:0,拥有的筷子ids: 3|1|, 数量：2,开始用餐
//    id:1,拥有的筷子ids: 0|1|,结束用餐
//    chopsticks id:3,被放弃使用开始
//    chopsticks id:3,被放弃使用结束
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    id:0,拥有的筷子ids: 3|1|,结束用餐
//    Philosopher id: 1,拥有筷子Chopstick id:3
//    Philosopher id: 2,拥有筷子Chopstick id:1
//    id:2,拥有的筷子ids: 4|1|, 数量：2,开始用餐
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束
//    chopsticks id:1,被放弃使用开始
//    Philosopher id: 4,拥有筷子Chopstick id:4
//    id:4,拥有的筷子ids: 0|4|, 数量：2,开始用餐
//    chopsticks id:1,被放弃使用结束
//    id:2,拥有的筷子ids: 4|1|,结束用餐
//    Philosopher id: 0,拥有筷子Chopstick id:1
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    Philosopher id: 1,拥有筷子Chopstick id:0
//    id:1,拥有的筷子ids: 3|0|, 数量：2,开始用餐
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束
//    id:4,拥有的筷子ids: 0|4|,结束用餐
//    Philosopher id: 0,拥有筷子Chopstick id:4
//    id:0,拥有的筷子ids: 1|4|, 数量：2,开始用餐
//    chopsticks id:3,被放弃使用开始
//    chopsticks id:3,被放弃使用结束
//    chopsticks id:0,被放弃使用开始
//    Philosopher id: 3,拥有筷子Chopstick id:3
//    id:3,拥有的筷子ids: 2|3|, 数量：2,开始用餐
//    chopsticks id:0,被放弃使用结束
//    id:1,拥有的筷子ids: 3|0|,结束用餐
//    Philosopher id: 4,拥有筷子Chopstick id:0
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    chopsticks id:4,被放弃使用开始
//    Philosopher id: 2,拥有筷子Chopstick id:1
//    chopsticks id:4,被放弃使用结束
//    id:0,拥有的筷子ids: 1|4|,结束用餐
//    Philosopher id: 2,拥有筷子Chopstick id:4
//    id:2,拥有的筷子ids: 1|4|, 数量：2,开始用餐
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    chopsticks id:3,被放弃使用开始
//    Philosopher id: 0,拥有筷子Chopstick id:2
//    chopsticks id:3,被放弃使用结束
//    id:3,拥有的筷子ids: 2|3|,结束用餐
//    Philosopher id: 0,拥有筷子Chopstick id:3
//    id:0,拥有的筷子ids: 2|3|, 数量：2,开始用餐
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    Philosopher id: 4,拥有筷子Chopstick id:1
//    id:4,拥有的筷子ids: 0|1|, 数量：2,开始用餐
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束
//    id:2,拥有的筷子ids: 1|4|,结束用餐
//    Philosopher id: 3,拥有筷子Chopstick id:4
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    chopsticks id:3,被放弃使用开始
//    Philosopher id: 1,拥有筷子Chopstick id:2
//    chopsticks id:3,被放弃使用结束
//    id:0,拥有的筷子ids: 2|3|,结束用餐
//    Philosopher id: 1,拥有筷子Chopstick id:3
//    id:1,拥有的筷子ids: 2|3|, 数量：2,开始用餐
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    chopsticks id:1,被放弃使用开始
//    Philosopher id: 3,拥有筷子Chopstick id:0
//    id:3,拥有的筷子ids: 4|0|, 数量：2,开始用餐
//    chopsticks id:1,被放弃使用结束
//    id:4,拥有的筷子ids: 0|1|,结束用餐
//    Philosopher id: 2,拥有筷子Chopstick id:1
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    chopsticks id:3,被放弃使用开始
//    Philosopher id: 0,拥有筷子Chopstick id:2
//    chopsticks id:3,被放弃使用结束
//    id:1,拥有的筷子ids: 2|3|,结束用餐
//    Philosopher id: 0,拥有筷子Chopstick id:3
//    id:0,拥有的筷子ids: 2|3|, 数量：2,开始用餐
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    id:3,拥有的筷子ids: 4|0|,结束用餐
//    Philosopher id: 1,拥有筷子Chopstick id:0
//    Philosopher id: 2,拥有筷子Chopstick id:4
//    id:2,拥有的筷子ids: 1|4|, 数量：2,开始用餐
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    chopsticks id:3,被放弃使用开始
//    Philosopher id: 1,拥有筷子Chopstick id:2
//    id:1,拥有的筷子ids: 0|2|, 数量：2,开始用餐
//    chopsticks id:3,被放弃使用结束
//    id:0,拥有的筷子ids: 2|3|,结束用餐
//    Philosopher id: 3,拥有筷子Chopstick id:3
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束
//    id:2,拥有的筷子ids: 1|4|,结束用餐
//    Philosopher id: 0,拥有筷子Chopstick id:1
//    Philosopher id: 4,拥有筷子Chopstick id:4
//    Philosopher id：1,12,Interrupted
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    Philosopher id: 3,拥有筷子Chopstick id:0
//    id:3,拥有的筷子ids: 3|0|, 数量：2,开始用餐
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    Philosopher id：3,14,Interrupted
//    chopsticks id:3,被放弃使用开始
//    Philosopher id: 4,拥有筷子Chopstick id:2
//    id:4,拥有的筷子ids: 4|2|, 数量：2,开始用餐
//    chopsticks id:3,被放弃使用结束
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    Philosopher id：4,15,Interrupted
//    Philosopher id: 2,拥有筷子Chopstick id:3
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束
//    chopsticks id:2,被放弃使用开始
//    Philosopher id: 0,拥有筷子Chopstick id:0
//    id:0,拥有的筷子ids: 1|0|, 数量：2,开始用餐
//    chopsticks id:2,被放弃使用结束
//    Philosopher id：0,11,Interrupted
//    chopsticks id:1,被放弃使用开始
//    Philosopher id: 2,拥有筷子Chopstick id:4
//    id:2,拥有的筷子ids: 3|4|, 数量：2,开始用餐
//    chopsticks id:1,被放弃使用结束
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    Philosopher id：2,13,Interrupted
//    chopsticks id:3,被放弃使用开始
//    chopsticks id:3,被放弃使用结束
//    chopsticks id:4,被放弃使用开始
//    chopsticks id:4,被放弃使用结束


//    Philosopher id: 0,拥有筷子Chopstick id:0
//    Philosopher id: 1,拥有筷子Chopstick id:1
//    Philosopher id: 0,拥有筷子Chopstick id:2
//    Philosopher id: 1,拥有筷子Chopstick id:3
//    id:0,拥有的筷子ids: 0|2|, 数量：2,开始用餐
//    id:1,拥有的筷子ids: 1|3|, 数量：2,开始用餐
//    Philosopher id: 2,拥有筷子Chopstick id:4
//    chopsticks id:0,被放弃使用开始
//    chopsticks id:0,被放弃使用结束
//    chopsticks id:1,被放弃使用开始
//    chopsticks id:1,被放弃使用结束
//    chopsticks id:3,被放弃使用开始
//    chopsticks id:3,被放弃使用结束
//    id:1,拥有的筷子ids: 1|3|,结束用餐
//    Philosopher id: 4,拥有筷子Chopstick id:1
//    Philosopher id: 3,拥有筷子Chopstick id:0
//    chopsticks id:2,被放弃使用开始
//    chopsticks id:2,被放弃使用结束
//    id:0,拥有的筷子ids: 0|2|,结束用餐
//    Philosopher id: 0,拥有筷子Chopstick id:2
//    Philosopher id: 1,拥有筷子Chopstick id:3


}
