package com.example.lcj.spring.Ioc.service.impl;

import com.example.lcj.spring.Ioc.dao.HelloDao;
import com.example.lcj.spring.Ioc.service.HelloService;

public class HelloServiceImpl2 implements HelloService {
    private HelloDao helloDao;

    public void setHelloDao(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    public void sayHello(String word) {
        System.out.println("service2");
        helloDao.sayHello(word);
    }
}