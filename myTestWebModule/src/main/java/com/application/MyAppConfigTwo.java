package com.application;


import com.bean.Apple;
import com.bean.Banana;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyAppConfigTwo {
    private Apple apple;

    //@Autowired,无需指定@Autowired
    public MyAppConfigTwo(Apple apple) {
        System.out.println("MyAppConfigTwo:"+apple);
        this.apple = apple;
    }

    @Bean
    public Banana findBanana(){
        return new Banana();
    }
}
