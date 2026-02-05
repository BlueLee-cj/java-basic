package com.example.lcj.spring.bean.create;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/10/19 21:33
 */
public class MyFactoryBean {
    public static CreateService staticGet(){
        return new CreateService();
    }

    public CreateService get(){
        return new CreateService();
    }
}
