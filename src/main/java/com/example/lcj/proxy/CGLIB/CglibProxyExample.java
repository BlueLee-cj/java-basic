package com.example.lcj.proxy.CGLIB;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ：lcj
 * @description：cglib代理
 * @date ：Created in 2019/9/13 9:31
 */
public class CglibProxyExample implements MethodInterceptor {
    /**
     * 生成CGLIB代理对象
     *
     * @param cls
     * @return
     */
    public Object getProxy(Class cls) {
        //增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     *
     * @param proxy
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象前");
        Object result = methodProxy.invokeSuper(proxy, args);
        System.out.println("调用真实对象后");
        return result;
    }
}
