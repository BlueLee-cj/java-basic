package com.example.lcj.spring.cycleDependence.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZZ implements ApplicationContextAware {
	@Autowired
    XX xx;//注入X

    //构造方法
	public ZZ(){
		System.out.println("ZZ create");
	}

    //生命周期初始化回调方法
	@PostConstruct
	public void zinit(){
		System.out.println("call zX lifecycle init callback");
	}

	//ApplicationContextAware 回调方法
	@Override
	public void setApplicationContext(ApplicationContext ac) {
		System.out.println("ZZ call aware callback");
	}
}