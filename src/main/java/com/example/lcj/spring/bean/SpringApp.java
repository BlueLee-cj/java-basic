package com.example.lcj.spring.bean;

import com.example.lcj.spring.aop.demo01.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//SpringApp.java文件
public class SpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/app.xml");
        HelloWorld hello = (HelloWorld) applicationContext.getBean("helloWorld");
        hello.sayHello();
        applicationContext.close();
    }
}
