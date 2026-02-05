package com.example.lcj;

import com.example.lcj.spring.aop.springaop.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zejian on 2017/2/19.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= "classpath:spring/aop/spring-aspectj.xml")
public class UserDaoAspectJ {
    @Autowired
    UserDao userDao;

    @Test
    public void aspectJTest(){
        userDao.addUser();
    }

    @Test
    public void aspectJTest_order(){
        userDao.deleteUser();
    }
}