package com.example.lcj.proxy.interceptor;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/9/13 10:27
 */
public class Test {
    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "com.example.lcj.proxy.interceptor.MyInterceptor");
        proxy.sayHelloWorld();
    }
}
