package com.example.lcj.spring.bean.AutowiringCollaborators;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main03 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/AutowiringCollaborators/application.xml");
		AutoService autoService = (AutoService) context.getBean("auto");
		autoService.print();
	}
}