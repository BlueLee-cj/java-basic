package com.example.lcj.spring.aop.demo02_AllException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//该注解定义全局异常处理类
//@ControllerAdvice
//@ResponseBody
// 使用@RestControllerAdvice可以替代上面两个注解
@RestControllerAdvice
//@ControllerAdvice(basePackages ="com.example.plugindemo.controller") 可指定包
public class GlobalExceptionHandler {
    @ExceptionHandler(value=GlobalException.class) //该注解声明异常处理方法
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        // 在这里针对异常做自己的处理
        return null;
    }
}
