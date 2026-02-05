package com.example.lcj.proxy.mybatisproxy.plugindemo;

public class FirstInterceptor implements Interceptor {
    /**
     * 执行拦截逻辑的方法
     */
    @Override
    public Object intercept(Invocation invocation) {
        try {
            return "plugin1 " + invocation.proceed() + " plugin1";
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 为原先的类生成代理对象
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}