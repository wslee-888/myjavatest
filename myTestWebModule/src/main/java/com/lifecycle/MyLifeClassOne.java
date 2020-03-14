package com.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class MyLifeClassOne implements InitializingBean,DisposableBean,SmartLifecycle{
    //方法一：InitializingBean和 DisposableBean回调接口
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口：destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口：afterPropertiesSet");
    }

    //方法二：spring 配置（xml或者注解均可）
    public void initTwo() throws Exception{
        System.out.println("spring life周期：initTwo");
    }

    public void destroyTwo() throws Exception{
        System.out.println("spring life周期：destroyTwo");
    }


    //方法三：@PostConstruct和@PreDestroy 注释
    @PostConstruct
    public void initThree() throws Exception{
        System.out.println("spring life周期：PostConstruct和");
    }

    @PreDestroy
    public void destroyThree() throws Exception{
        System.out.println("spring life周期：PreDestroy");
    }


    @Override
    public boolean isAutoStartup() {
        System.out.println("isAutoStartup");
        return false;
    }

    @Override
    public void stop(Runnable runnable) {
        System.out.println("stop");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public int getPhase() {
        System.out.println("getPhase");
        return 0;
    }

    @Override
    public boolean isRunning() {
        System.out.println("isRunning");
        return false;
    }
}
