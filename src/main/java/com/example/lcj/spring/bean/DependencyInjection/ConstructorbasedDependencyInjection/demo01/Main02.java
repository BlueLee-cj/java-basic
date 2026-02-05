package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main02 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new
            // config类主要完成对类的扫描
            AnnotationConfigApplicationContext(ConstructorConfig.class);
		ConService service = (ConService) ac.getBean("conService");
		service.test();
	}
}