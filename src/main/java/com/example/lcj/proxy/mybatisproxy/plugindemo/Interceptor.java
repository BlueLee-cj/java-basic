package com.example.lcj.proxy.mybatisproxy.plugindemo;


public interface Interceptor {
    /**
     * 执行拦截逻辑的方法
     */
    Object intercept(Invocation invocation);

    /**
     * target是被拦截的对象，它的作用是给被拦截对象生成一个代理对象，并返回它。
     * 为了方便，可以直接使用Mybatis中org.apache.ibatis.plugin类的wrap方法（是静态方法）
     * 生成代理对象
     * 我这里也写了一个Plugin方法
     */
    Object plugin(Object target);
}