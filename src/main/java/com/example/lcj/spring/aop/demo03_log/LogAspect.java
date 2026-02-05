package com.example.lcj.spring.aop.demo03_log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("@annotation(com.example.lcj.spring.aop.demo03_log.Log)")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        Object[] args = joinPoint.getArgs();
        String methodName = method.getName();
        Class<?> declaringClass = method.getDeclaringClass();
        String simpleName = declaringClass.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName).append(".").append(methodName).append(" [");
        for (int i = 0; i < parameters.length; i++) {
            String name = parameters[i].getName();
            sb.append(name);
            sb.append(":");
            sb.append(args[i]);
            sb.append(";");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        log.info(sb.toString());
    }
}
