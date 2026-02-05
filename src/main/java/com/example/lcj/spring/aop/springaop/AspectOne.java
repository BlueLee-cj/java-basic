package com.example.lcj.spring.aop.springaop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by zejian on 2017/2/20.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class AspectOne {

    /**
     * Pointcut定义切点函数
     */
    @Pointcut("execution(* com.example.lcj.spring.aop.springaop.UserDao.addUser(..))")
    private void myPointcut(){}

    @Before("myPointcut()")
    public void beforeOne(){
        System.out.println("前置通知....执行顺序1");
    }

    //@Before("myPointcut()")
    //public void beforeTwo(){
    //    System.out.println("前置通知....执行顺序2");
    //}

    @AfterReturning(value = "myPointcut()")
    public void AfterReturningThree(){
        System.out.println("后置通知....执行顺序1");
    }

    //@AfterReturning(value = "myPointcut()")
    //public void AfterReturningFour(){
    //    System.out.println("后置通知....执行顺序4");
    //}
}

