package com.example.lcj.spring.Ioc.dao.impl;

import com.example.lcj.spring.Ioc.dao.HelloDao;

public class HelloHibernateImpl implements HelloDao {
    public void sayHello(String word) {
        System.out.println("-----------hibernate--------" + word);
    }
}