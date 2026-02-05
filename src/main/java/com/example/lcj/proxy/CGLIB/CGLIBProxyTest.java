package com.example.lcj.proxy.CGLIB;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/9/13 9:50
 */
public class CGLIBProxyTest {
    public static void main(String[] args) {
        CglibProxyExample cpe = new CglibProxyExample();
        HelloWorld proxy = (HelloWorld) cpe.getProxy(HelloWorld.class);
        proxy.sayHelloWorld();
    }
}
