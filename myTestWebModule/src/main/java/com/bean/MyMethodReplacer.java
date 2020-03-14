package com.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class MyMethodReplacer implements MethodReplacer{
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
