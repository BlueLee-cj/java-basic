package com.example.lcj.spring.cycleDependence.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {
	@Autowired
	ServiceA serviceA;
	
	public ServiceB(){
		System.out.println("ServiceB create");
	}
}