package com.example.lcj.spring.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * 测试类
 * @author LinJie
 * 
 */
public class CycleTest {
    @Test
 	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/applicationContext.xml");
		Student student = (Student) context.getBean("student");
		//Bean的使用
		student.play();
		System.out.println(student);
		//关闭容器
		((AbstractApplicationContext) context).close();
	}
}
