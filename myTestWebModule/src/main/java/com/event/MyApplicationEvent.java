package com.event;

import org.springframework.context.ApplicationEvent;

//spring事件(使用的是观察者模式)
public class MyApplicationEvent extends ApplicationEvent{
    private String adress;
    private String context;

    public MyApplicationEvent(Object source,String adress,String context) {
        super(source);
        this.adress = adress;
        this.context = context;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
