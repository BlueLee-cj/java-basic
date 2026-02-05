package com.example.lcj.spring.bean.InstantiatingBeans.method04InstanceFactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AutoWiredTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/springautowired.xml");
        //获取相应实体
        Chinese c = (Chinese) context.getBean("ch", Person.class);
        c.say();
        American a = (American) context.getBean("usa", Person.class);
        a.say();
        //关闭容器
        ((AbstractApplicationContext) context).close();
    }
}