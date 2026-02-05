package com.example.lcj.proxy.mybatisproxy.plugindemo;

public class SecondInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) {
        try {
            return "plugin2 " + invocation.proceed() + " plugin2";
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}