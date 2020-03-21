package com.listener;

import com.event.MyApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyAppEventListener implements ApplicationListener<MyApplicationEvent>{
    @Override
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        System.out.println("发送者："+myApplicationEvent.getAdress()+",收到信息："+myApplicationEvent.getContext());
    }
}
