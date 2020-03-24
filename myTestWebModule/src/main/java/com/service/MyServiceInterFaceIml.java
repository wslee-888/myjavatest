package com.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class MyServiceInterFaceIml implements MyServiceInterface{

    public String testOne() throws Exception{
        System.out.println("业务层方法：testOne");
        String str = null;
        //System.out.println(str.length());
        return "哈哈哈哈哈哈";
    }

}
