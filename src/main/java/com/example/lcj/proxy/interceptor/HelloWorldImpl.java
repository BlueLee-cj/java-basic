package com.example.lcj.proxy.interceptor;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/9/13 9:40
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
