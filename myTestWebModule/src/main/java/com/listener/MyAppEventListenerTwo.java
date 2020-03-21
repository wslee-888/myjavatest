package com.listener;

import com.event.MyApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

public class MyAppEventListenerTwo {

    @EventListener
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent){

    }


    @EventListener({MyApplicationEvent.class})
    public void onApplicationEventTwo(){

    }

    @EventListener({MyApplicationEvent.class})
    @Async
    @Order(88)
    public void onApplicationEventThree(){

    }
}
