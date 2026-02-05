package com.example.lcj.spring.cycleDependence.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/21 10:16
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        XXX bean = ac.getBean(XXX.class);
        System.out.println(bean);
    }
}
