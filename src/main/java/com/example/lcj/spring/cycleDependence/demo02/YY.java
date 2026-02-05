package com.example.lcj.spring.cycleDependence.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YY {
	@Autowired
    XX xx;
	
	public YY(){
		System.out.println("YY create");
	}
}