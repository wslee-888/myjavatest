package com.application;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectTwo {

    public void myBeforeAdviceTwo(JoinPoint joinPoint){
        System.out.println("前置通知");
        System.out.println("方法参数："+joinPoint.getArgs());
        System.out.println("代理对象："+joinPoint.getThis());
        System.out.println("目标对象："+joinPoint.getTarget());
        System.out.println("建议使用的方法的描述："+joinPoint.getSignature());
        System.out.println("打印有关所建议方法的有用说明："+joinPoint.toString());
    }


    public void myAfterReturningAdviceTwo(Object result){
        System.out.println("后置通知");
    }

    public void myAfterThrowingAdviceTwo(JoinPoint joinPoint,Exception ex){
        System.out.println("异常通知");
    }

    public void myAfterFinallyAdviceTwo(){
        System.out.println("最终通知");
    }

    public void myAroundAdviceTwo(JoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前");
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知后");
    }

}
