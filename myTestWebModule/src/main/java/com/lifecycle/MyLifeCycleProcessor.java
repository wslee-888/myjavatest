package com.lifecycle;

import org.springframework.context.LifecycleProcessor;

public class MyLifeCycleProcessor implements LifecycleProcessor{
    @Override
    public void onRefresh() {

    }

    @Override
    public void onClose() {

    }

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
