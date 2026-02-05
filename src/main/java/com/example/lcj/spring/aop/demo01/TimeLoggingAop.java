package com.example.lcj.spring.aop.demo01;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * 记录方法的执行时间
 */
public class TimeLoggingAop implements MethodBeforeAdvice, AfterReturningAdvice {
    private long startTime = 0;

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        startTime = System.nanoTime();

    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        long spentTime = System.nanoTime() - startTime;
        String clazzName = target.getClass().getCanonicalName();
        String methodName = method.getName();
        System.out.println("执行" + clazzName + "#" + methodName + "消耗" + new BigDecimal(spentTime).divide(new BigDecimal(1000000)) + "毫秒");
    }

    /**
     * HelloWorld为目标对象
     * TimeLogAOP实现了BeforeAdvice，AfterReturningAdvice 是 Advice
     * Pointcut为HelloWorld的方法执行前与方法返回值后，两个切点
     * 织入过程为Spring内部实现
     */
}