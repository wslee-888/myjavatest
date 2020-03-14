package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

@Component("myClassSix888")
//@Named("myClassSix888")
//@ManagedBean
//@Scope("singleton")
//@Singleton
public class MyClassSix {

    @Value(value = "${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;

    private MyClassEight myClassEight;

    //private Provider provider;

    public MyClassSix() {
    }

  /*  @Bean("")
    public MyClassSix findMyClassSix() {
        return new MyClassSix();
    }*/

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MyClassEight getMyClassEight() {
        return myClassEight;
    }


    @Autowired
    @Lazy
    public void setMyClassEightOne(MyClassEight myClassEight) {
        this.myClassEight = myClassEight;
    }

    @Inject
    public void setMyClassEightTwo(MyClassEight myClassEight) {
        this.myClassEight = myClassEight;
    }
}
