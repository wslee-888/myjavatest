package com.application;

import com.bean.Orange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


//@Configuration
@PropertySource(value = {"classpath:properties/database.properties","classpath:properties/myPropertyConfig.properties"},encoding="UTF-8")
public class MyPropertyConfig {
    //系统配置获取顺序
//    ServletConfig参数（如果适用，例如在DispatcherServlet上下文的情况下）
//
//    ServletContext参数（web.xml上下文参数条目）
//
//    JNDI环境变量（java:comp/env/条目）
//
//    JVM系统属性（-D命令行参数）
//
//    JVM系统环境（操作系统环境变量）
    @Value("${appName}")
    String appName;

    @Value("${version}")
    String version;


    @Value("${author}")
    String author;

    @Autowired
    Environment environment;

    @Bean
    public Orange findEnvironmentMsg(){

        System.out.println("MyPropertyConfig:"+appName+","+version+","+author);

        System.out.println("appName:"+environment.getProperty("appName"));
        System.out.println("version:"+environment.getProperty("version"));
        System.out.println("author:"+environment.getProperty("author"));
        System.out.println("updateTime:"+environment.getProperty("updateTime"));
        System.out.println("target:"+environment.getProperty("target"));

        System.out.println("jdbc.driverClassName:"+environment.getProperty("jdbc.driverClassName"));
        System.out.println("jdbc.url:"+environment.getProperty("jdbc.url"));
        System.out.println("jdbc.username:"+environment.getProperty("jdbc.username"));
        System.out.println("jdbc.password:"+environment.getProperty("jdbc.password"));

        return new Orange();
    }



}
