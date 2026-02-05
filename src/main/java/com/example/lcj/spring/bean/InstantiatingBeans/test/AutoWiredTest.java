package com.example.lcj.spring.bean.InstantiatingBeans.test;

import com.example.lcj.spring.bean.InstantiatingBeans.method01Set.SpringAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredTest {
    @Test
 	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/springautowired.xml");
		SpringAction springAction = (SpringAction) context.getBean("springAction");
		//Bean的使用
		System.out.println(springAction.ok());
		//关闭容器
		((AbstractApplicationContext) context).close();
	}
}