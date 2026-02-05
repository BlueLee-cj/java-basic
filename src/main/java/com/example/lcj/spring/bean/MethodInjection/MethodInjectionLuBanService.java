package com.example.lcj.spring.bean.MethodInjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// 原型对象
@Scope("prototype")
public class MethodInjectionLuBanService {
	int i;

	MethodInjectionLuBanService() {
		System.out.println("luBan create ");
	}
	// 每次将当前对象的属性i+a然后打印
	public void addAndPrint(int a) {
		i+=a;
		System.out.println(i);
	}
}