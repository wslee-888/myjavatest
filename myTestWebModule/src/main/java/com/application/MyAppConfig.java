package com.application;

import com.bean.Apple;
import com.bean.Banana;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Configuration
@ComponentScan(basePackages = "com.bean")
/*@ComponentScan(basePackages = "com",
        includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class) },
        excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class) },
        useDefaultFilters = true ,nameGenerator =
        ,scopedProxy = ,scopeResolver =
        ,resourcePattern = )*/
// ANNOTATION,
//    ASSIGNABLE_TYPE,
//    ASPECTJ,
//    REGEX,
//    CUSTOM;

/*includeFilters = {@ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = {MyAspect.class,MyAdvice.class},
        value = {Component.class,Service.class},
        pattern = {})}*/

//@ComponentScans()
@ImportResource("classpath:./spring/my_spring_database.xml")
public class MyAppConfig {
    /*private Orange orange;

    public MyAppConfig() {
    }

    public MyAppConfig(Orange orange) {
        System.out.println("MyAppConfig:"+orange);
        this.orange = orange;
    }*/


    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;




     @Bean({"applePai","appleDrink","appleWatch"})
     @Primary
     @Qualifier("apple")
     //@Genre
     //@Offline
     @Description("苹果产品信息表")
     public Apple findApple(){
         return new Apple();
     }

     @Bean(initMethod = "init",destroyMethod = "cleanUp")
     //@Scope("singleton")
     @Scope(value = "singleton",proxyMode = ScopedProxyMode.NO)
     //@RequestScope
     //@SessionScope
     //@ApplicationScope
     //@WebSocketScope

     public Banana findBanana(){
         Banana banana = new Banana();
         //banana.init();
         return banana;
     }

     public void getFruit(){
         System.out.println("apple:"+findApple()+",banana:"+findBanana());
     }

    @Override
    public String toString() {
        return "MyAppConfig{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
