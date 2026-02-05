package com.example.lcj.spring.bean.BeanDefinitionInheritance;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("spring/bean/BeanDefinitionInheritance/application.xml");
		DerivedTestBean derivedTestBean = (DerivedTestBean) cc.getBean("child");
		//TestBean testBean1 = (TestBean) cc.getBean("parent");
		System.out.println("derivedTestBean的name = " + derivedTestBean.getName());
		System.out.println("derivedTestBean的age = " + derivedTestBean.getAge());
	}
}