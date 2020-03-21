package com.applicaton;

import com.event.MyApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

public class MyEventPublisherService implements ApplicationEventPublisherAware{
    private ApplicationEventPublisher publisher;
    private List<String> blackList;

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }


    public void sendEmail(String address, String content) {
        if (blackList.contains(address)) {
            publisher.publishEvent(new MyApplicationEvent(this, address, content));
            return;
        }
    }
}
