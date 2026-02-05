package com.example.lcj.spring.bean.DependencyInjection.SetterbasedDependencyInjection.demo01;

import org.springframework.stereotype.Component;

@Component
public class LuBanService {
	LuBanService(){
		System.out.println("luBan create ");
	}
}