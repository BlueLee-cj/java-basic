package com.example.lcj.spring.Ioc;

import com.example.lcj.spring.Ioc.controller.HelloController;
import com.example.lcj.spring.Ioc.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 加载Spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/ioc/simpleIoc.xml");
        HelloController controller = (HelloController) applicationContext.getBean("controller");
        //HelloController controller1 = (HelloController) applicationContext.getBean("controller1");
        //System.out.println(controller == controller1);
        //HelloService service1 = (HelloService) applicationContext.getBean("service");
        //HelloService service2 = controller.getHelloService();
        //System.out.println(service1 == service2);
        //ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring/ioc/simpleIoc.xml");
        //HelloController controller2 = (HelloController) applicationContext2.getBean("controller");
        //System.out.println(controller == controller2);
        controller.sayHello("你好");
    }
}
