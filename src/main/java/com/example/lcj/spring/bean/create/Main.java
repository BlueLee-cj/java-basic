package com.example.lcj.spring.bean.create;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
        // 通过配置类扫描
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		System.out.println(ac.getBean("service"));

		//ClassPathXmlApplicationContext cc =
		//		new ClassPathXmlApplicationContext("spring/ioc/application.xml");
		//System.out.println(cc.getBean("conService"));
	}
}
