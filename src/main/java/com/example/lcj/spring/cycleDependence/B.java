package com.example.lcj.spring.cycleDependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component
public class B {


	private A a;

	//public B(A a){
	//	this.a = a;
	//}

	@Autowired
	public void setA(A a) {
		this.a = a;
	}

	public A getA() {
		return a;
	}
}