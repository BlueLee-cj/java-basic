package com.example.lcj.spring.Ioc.singleton;

import com.example.lcj.jdk8NewSyntax.lambda.Hello;
import com.example.lcj.spring.Ioc.controller.HelloController;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/1/5 17:23
 */
public class SingletonTest {
    private static ApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("spring/ioc/simpleIoc.xml");
    }

    @Test
    public void testInstance() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/ioc/simpleIoc.xml");
        HelloController controller1 = (HelloController) applicationContext.getBean(HelloController.class);
        HelloController controller2 = (HelloController) applicationContext.getBean(HelloController.class);
        Assert.assertSame("difffert", controller1, controller2);
    }
}
