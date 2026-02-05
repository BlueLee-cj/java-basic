package com.example.lcj.interceptor.demo03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 8:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {
    int id() default 0;
}
