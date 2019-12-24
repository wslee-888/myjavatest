package com.liws.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyThreadThree implements Callable{

    public Object call() throws Exception {
        for (int i = 0;i < 5;i++) {
            System.out.println(Thread.currentThread().getName());
        }
        return 123;
    }
}
