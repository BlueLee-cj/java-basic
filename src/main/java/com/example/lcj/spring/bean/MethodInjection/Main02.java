package com.example.lcj.spring.bean.MethodInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main02 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MethodInjectionConfig.class);
		MyService service = (MyService) ac.getBean("myService");
		service.test(1);
		service.test(2);
		service.test(3);
	}
}

	//luBan create
	//	1
	//	3
	//	6
/**
 这个结果说明我们每次调用到的LuBanService是同一个对象。
 当然，这也很好理解，因为在依赖注入阶段我们就完成了LuBanService的注入，
 之后我们在调用测试方法时，不会再去进行注入，所以我们一直使用的是同一个对象。

 我们可以这么说，原型对象在这种情况下，失去了原型的意义，因为每次都使用的是同一个对象。
 那么如何解决这个问题呢？只要我每次在使用这个Bean的时候都去重新获取就可以了，那么这个时候我们可以通过方法注入来解决。通过注入上下文（applicationContext对象）
 */