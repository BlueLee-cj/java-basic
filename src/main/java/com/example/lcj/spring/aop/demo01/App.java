package com.example.lcj.spring.aop.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 加载Spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/app.xml");
        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        helloWorld.sayHello();

    }
}
