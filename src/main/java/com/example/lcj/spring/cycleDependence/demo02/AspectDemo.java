package com.example.lcj.spring.cycleDependence.demo02;

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
public class AspectDemo {

    /**
     * Pointcut定义切点函数
     */
    @Pointcut("execution(* com.example.lcj.spring.cycleDependence.demo02.XX.add(..))")
    private void myPointcut(){}

    @Before("myPointcut()")
    public void beforeOne(){
        System.out.println("前置通知....执行顺序1");
    }

    @AfterReturning(value = "myPointcut()")
    public void AfterReturningThree(){
        System.out.println("后置通知....执行顺序1");
    }

}

