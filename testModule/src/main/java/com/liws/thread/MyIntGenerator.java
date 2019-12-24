package com.liws.thread;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class MyIntGenerator{

    private int currentValue = 10;
    private static Integer lastValue = 10;
    private Lock lock = new ReentrantLock();
    private StampedLock stampedLock = new StampedLock();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private AtomicInteger atomicInteger = new AtomicInteger();//原子类操作(CAS)
    private volatile int num = 10;
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    public static String lockStr = "123";
    private Condition condition = lock.newCondition();

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public synchronized int next() throws Exception{
        if (currentValue > 0){
/*            if (currentValue % 2 == 0){
                Thread.sleep(500);
            }*/
            //TimeUnit.MILLISECONDS.sleep(500);

            currentValue --;
            System.out.println(Thread.currentThread().getName()+",666666,"+currentValue);
        }

        //this.wait();

        //currentValue--;

        //this.notify();


        return currentValue;
    }

    public synchronized static int last() throws Exception{
        if (lastValue > 0){
            /*if (lastValue % 2 == 0){
                Thread.sleep(500);
            }*/
            Thread.yield();
            lastValue --;
            System.out.println(Thread.currentThread().getName()+","+lastValue);
        }

        //this.wait();

        //currentValue--;

        //this.notify();


        return lastValue;
    }

    public int mid(){
        synchronized (lockStr){
            if (currentValue > 0){
                //Thread.yield();
               /* try {
                    System.out.println(Thread.currentThread().getName()+",888888沉睡前，value:" + currentValue);
                    TimeUnit.MILLISECONDS.sleep(500);

                    System.out.println(Thread.currentThread().getName()+",888888睡醒后，value:" + currentValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                currentValue--;
                System.out.println(Thread.currentThread().getName()+",888888,"+currentValue);
            }
            return currentValue;
        }
    }

    public int first() throws Exception{
        lock.lock();
        //boolean isLock = lock.tryLock();
        //boolean isLock = lock.tryLock(2,TimeUnit.SECONDS);
       // System.out.println(Thread.currentThread().getName()+","+isLock);

        try {
            //isLock &&
            if (currentValue > 0){
                //Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                currentValue--;

                //if (currentValue % 2 ==0){
                    //condition.await();
                    //condition.signal();

                //}
            }

            System.out.println(Thread.currentThread().getName()+",888888,"+currentValue);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //if (isLock){
               // lock.unlock();
            //}
        }
        return currentValue;
    }


    public int second() throws Exception{
        if (num > 0){
            num --;
            System.out.println(Thread.currentThread().getName()+","+num);
        }

        //this.wait();

        //currentValue--;

        //this.notify();


        return num;
    }

    public void third() throws Exception{
        lock.lock();
        //boolean isLock = lock.tryLock();
        //boolean isLock = lock.tryLock(2,TimeUnit.SECONDS);
        // System.out.println(Thread.currentThread().getName()+","+isLock);

        try {
            //isLock &&
            if (currentValue > 0){
                //Thread.yield();
                //TimeUnit.MILLISECONDS.sleep(200);
                TimeUnit.SECONDS.sleep(100000000);
                currentValue--;

                //if (currentValue % 2 ==0){
                //condition.await();
                //condition.signal();

                //}
            }

            System.out.println(Thread.currentThread().getName()+",666666,"+currentValue);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //if (isLock){
            lock.unlock();
            //}
        }
    }

    public void five(Integer lock) throws Exception{

        synchronized (lock){
            if (currentValue > 0){
                currentValue--;
                System.out.println(Thread.currentThread().getName()+",999999,"+currentValue);
            }
        }
    }

    public void six(Integer lock) throws Exception{
        synchronized (lock){
            if (currentValue > 0){
                currentValue--;
                System.out.println(Thread.currentThread().getName()+",aaaaaa,"+currentValue);
            }
        }
    }
}
