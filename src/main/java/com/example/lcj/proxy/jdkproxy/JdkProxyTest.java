package com.example.lcj.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/9/13 9:41
 */
public class JdkProxyTest {
    public static void main(String[] args) {

        JdkProxyExample jdk = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();

        HelloWorldImpl helloWorld = new HelloWorldImpl();
        HelloWorld proxy2 = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("在调度真实对象之前的服务111111");
                        Object obj = method.invoke(helloWorld, args);
                        System.out.println("在调度真实对象之后的服务222222");
                        return obj;
                    }
                }
        );
        proxy2.sayHelloWorld();
    }
}
