package com.example.lcj.spring.bean.beandefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main1(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(Appconfig.class);
        ac.refresh();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext();
        ac.register(Appconfig.class);
        ac.refresh();
        // 正常打印
        System.out.println(ac.getBean(Y.class));
        // 正常打印
        System.out.println(ac.getBean(Z.class));
        // 异常打印
        // 虽然X加了注解，但是被偷梁换柱了，故而异常
        System.out.println(ac.getBean(X.class));
    }

}
