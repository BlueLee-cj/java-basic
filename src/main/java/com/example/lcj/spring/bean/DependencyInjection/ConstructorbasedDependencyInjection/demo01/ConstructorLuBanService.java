package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo01;

import org.springframework.stereotype.Component;

@Component
public class ConstructorLuBanService {
	ConstructorLuBanService(){
		System.out.println("luBan create ");
	}
}