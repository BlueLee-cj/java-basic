package com.example.lcj.proxy.interceptor;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/9/13 10:14
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Object[] args) {
        System.out.println("反射方法前逻辑");
        System.out.println(proxy.getClass().getName());
        System.out.println(target);
        System.out.println(args);
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Object[] args) {
        System.out.println("取代了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Object[] args) {
        System.out.println("反射方法后逻辑");
    }
}
