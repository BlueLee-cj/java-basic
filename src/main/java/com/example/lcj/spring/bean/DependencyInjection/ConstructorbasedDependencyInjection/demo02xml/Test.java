package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo02xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/22 22:48
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(App.class);
        ac.refresh();
        ac.getBean(ADemo.class).print();
    }
}
