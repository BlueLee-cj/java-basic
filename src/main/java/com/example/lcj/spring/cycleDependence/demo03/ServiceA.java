package com.example.lcj.spring.cycleDependence.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {

	@Autowired
	ServiceB serviceB;

	public ServiceA(){
		System.out.println("ServiceA create");
	}

}