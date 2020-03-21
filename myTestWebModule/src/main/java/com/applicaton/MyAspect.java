package com.applicaton;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* test*(..))")
    public void myBeforeAdvice(){

    }

    public void myAfterReturningAdvice(){

    }

    public void myAfterThrowingAdvice(){

    }

    public void myAfterFinallyAdvice(){

    }

    public void myAroundAdvice(){

    }
}
