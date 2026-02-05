package com.example.lcj.spring.aop.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser() {
        System.out.println("servce add user begin......");
        return userDao.addUser();
    }

}