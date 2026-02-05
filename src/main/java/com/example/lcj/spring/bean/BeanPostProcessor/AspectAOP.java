package com.example.lcj.spring.bean.BeanPostProcessor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Aspect
@EnableAspectJAutoProxy
@Component
public class AspectAOP {

    /**
     * Pointcut定义切点函数
     */
    @Pointcut("execution(* com.example.lcj.spring.bean.BeanPostProcessor.IndexService.print(..))")
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

