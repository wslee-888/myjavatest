package com.application;

import com.bean.Apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration
@Import(MyAppConfigTwo.class)
//@Import({MyAppConfigTwo.class,MyAppConfig.class})
public class MyAppConfigOne {

    @Bean
    public Apple findApple(){
        return new Apple();
    }

}
