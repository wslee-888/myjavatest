package com.liws.other.otherBean;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught:"+e);
    }
}
