package com.applicaton;

import com.bean.Apple;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplication implements ApplicationContextAware{
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
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
