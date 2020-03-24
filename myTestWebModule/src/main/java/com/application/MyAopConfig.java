package com.application;

import com.service.MyServiceInterFaceIml;
import com.service.MyServiceInterface;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@EnableAspectJAutoProxy
//注解方式开启springaop切面编程支持
//@ComponentScan(basePackages = {"com.application","com.service"})
public class MyAopConfig {

    @Bean
    public MyAspect findMyAspect(){
        return new MyAspect();
    }

    @Bean
    public MyServiceInterface findMyService(){
        return new MyServiceInterFaceIml();
    }
}
