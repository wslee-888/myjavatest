package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("singleton")
public class MyClassFive {

    private MyClassSix myClassSix;

    public MyClassSix getMyClassSix() {
        return myClassSix;
    }

    @Resource(name = "myClassSix888")
    //@Resource(type = MyClassSix.class)
    public void setMyClassSix(MyClassSix myClassSix) {
        this.myClassSix = myClassSix;
    }
}
