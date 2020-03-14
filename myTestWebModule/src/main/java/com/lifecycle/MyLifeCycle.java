package com.lifecycle;

import org.springframework.context.Lifecycle;

public class MyLifeCycle implements Lifecycle{
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
