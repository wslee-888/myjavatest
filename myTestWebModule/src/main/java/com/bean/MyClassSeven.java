package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.lang.annotation.*;

//使用元注释和组合注释,可能等同@Service，和 @Controller等
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyClassSeven {

}

