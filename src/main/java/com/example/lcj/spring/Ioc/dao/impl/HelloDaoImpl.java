package com.example.lcj.spring.Ioc.dao.impl;

import com.example.lcj.spring.Ioc.dao.HelloDao;

public class HelloDaoImpl implements HelloDao {

    public HelloDaoImpl() {
    }

    public void sayHello(String word) {
        System.out.println("-----------dao--------" + word);
    }
}