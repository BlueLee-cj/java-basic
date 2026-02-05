package com.example.lcj.spring.bean.InstantiatingBeans.method03StaticFactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AutoWiredTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/springautowired.xml");
        //获取相应实体
        Chinese c = (Chinese) context.getBean("chinese", Person.class);
        c.say();
        American a = (American) context.getBean("american", Person.class);
        a.say();
        //关闭容器
        ((AbstractApplicationContext) context).close();
    }
}