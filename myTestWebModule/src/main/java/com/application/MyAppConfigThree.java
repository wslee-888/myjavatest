package com.application;

import com.bean.Apple;
import com.bean.Banana;
import com.bean.Orange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//@ActiveProfiles(profiles = {"dev"})
//@Profile("default")
public class MyAppConfigThree {

    //测试环境配置
    @Bean(value = "testConfig")
    @Profile("test")
    public Orange getTestConfig(){
        return new Orange();
    }

    //开发环境配置
    @Bean("devConfig")
    @Profile("dev")
    public Apple getDevConfig(){
        return new Apple();
    }

    //生产环境配置
    @Bean("proConfig")
    @Profile("pro")
    public Banana getProConfig(){
        return new Banana();
    }


}
