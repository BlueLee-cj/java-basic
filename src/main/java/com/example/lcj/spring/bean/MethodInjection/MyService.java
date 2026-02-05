package com.example.lcj.spring.bean.MethodInjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

//@Component
//public class MyService {
//
//	@Autowired
//	private LuBanService luBanService;
//
//	public void Test(int a){
//		luBanService.addAndPrint(a);
//	}
//
//}

//通过注入上下文（applicationContext对象）
//方式一、实现org.springframework.context.ApplicationContextAware接口
//@Component
//public class MyService implements ApplicationContextAware {
//
//	private ApplicationContext applicationContext;
//
//	public void Test(int a) {
//		LuBanService luBanService = ((LuBanService) applicationContext.getBean("luBanService"));
//		luBanService.addAndPrint(a);
//	}
//
//	@Override
//	public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = applicationContext;
//	}
//}

//方式二、直接注入上下文

//@Component
//public class MyService{
//	@Autowired
//	private ApplicationContext applicationContext;
//
//	public void Test(int a) {
//		LuBanService luBanService = ((LuBanService) applicationContext.getBean("luBanService"));
//		luBanService.addAndPrint(a);
//	}
//}


//方式三、LookUp

@Component
public class MyService{
	public void test(int a) {
		MethodInjectionLuBanService luBanService = lookUp();
		luBanService.addAndPrint(a);
	}
	//
	@Lookup
	public MethodInjectionLuBanService lookUp(){
		return null;
	}
}


