package com.bean;

import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;

//@Component
//@Scope("singleton")
public class MyClassFour {
    @Autowired
    BeanFactory beanFactory;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    Environment environment;
    @Autowired
    ResourceLoader resourceLoader;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    MessageSource messageSource;

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }


    /*@Autowired
    public void findClassFiveOptional(Optional<MyClassFive> optional){
    }

    @Autowired
    public void findClassFive(@Nullable MyClassFive myClassFive){
        System.out.println(myClassFive);
    }*/

/*    @Override
    public String toString() {
        return "MyClassFour{" +
                "beanFactory=" + beanFactory +
                ", applicationContext=" + applicationContext +
                ", environment=" + environment +
                ", resourceLoader=" + resourceLoader +
                ", applicationEventPublisher=" + applicationEventPublisher +
                ", messageSource=" + messageSource +
                '}';
    }*/
}
