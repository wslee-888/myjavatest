package com.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class MyApplication implements ApplicationContextAware{
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }



     /*ApplicationContextAware applicationContextAware;

      BeanNameAware beanNameAware;

      ApplicationEventPublisherAware

      BeanClassLoaderAware

      BeanFactoryAware

      BeanNameAware

      BootstrapContextAware

      LoadTimeWeaverAware

      MessageSourceAware

      NotificationPublisherAware

      ResourceLoaderAware

      ServletConfigAware

      ServletContextAware

      Enviroment*/
}
