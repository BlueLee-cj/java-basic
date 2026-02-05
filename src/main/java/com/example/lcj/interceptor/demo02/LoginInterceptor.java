package com.example.lcj.interceptor.demo02;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle() {
        System.out.println("LoginInterceptor 执行了");
        return true;
    }
}