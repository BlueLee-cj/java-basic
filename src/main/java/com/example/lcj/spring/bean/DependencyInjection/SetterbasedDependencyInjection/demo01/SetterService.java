package com.example.lcj.spring.bean.DependencyInjection.SetterbasedDependencyInjection.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterService {

	private LuBanService luBanService;

	//public SetterService() {
	//	System.out.println("SetterService create");
	//}
	// 通过Autowired指定使用这个构造函数，否则默认会使用无参

	 //通过autowired指定使用set方法完成注入
	@Autowired
	public void setLuBanService(LuBanService luBanService) {
		System.out.println("注入luBanService by setter");
		this.luBanService = luBanService;
	}

	public void test(){
		System.out.println(luBanService);
	}

}
