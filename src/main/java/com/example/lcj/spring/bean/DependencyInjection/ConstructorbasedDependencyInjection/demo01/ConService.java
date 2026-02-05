package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo01;

import org.springframework.stereotype.Component;

@Component
public class ConService {

	private ConstructorLuBanService luBanService;
    
    //public ConService() {
	//	System.out.println("ConService create by no args constructor");
	//}
	
    // 通过Autowired指定使用这个构造函数，否则默认会使用无参
	//@Autowired
	public ConService(ConstructorLuBanService luBanService) {
		System.out.println("注入luBanService by constructor with arg");
		this.luBanService = luBanService;
		System.out.println("service create by constructor with arg");
	}

	public void test(){
		System.out.println(luBanService);
	}
}
