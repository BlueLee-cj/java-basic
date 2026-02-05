package com.example.lcj.reflect.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 在运行期动态创建一个interface实例的方法如下：
 * 1、定义一个InvocationHandler实例，它负责实现接口的方法调用；
 * 2、通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
 * a、使用的ClassLoader，通常就是接口类的ClassLoader；
 * b、需要实现的接口数组，至少需要传入一个接口进去；
 * c、用来处理接口方法调用的InvocationHandler实例。
 * 3、将返回的Object强制转型为接口。
 */
public class Main {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[]{Hello.class}, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}