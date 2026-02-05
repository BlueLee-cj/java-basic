package com.example.lcj.designpattern.TemplateMethod.demo01;

/**
 * Created by jiangxs on 2018/5/7.
 */
public class Client {

    public static void main(String[] args) {

        AbstractClass c;

        c = new ConcreteClassA();
        c.templateMethod();

        c = new ConcreteClassB();
        c.templateMethod();
    }
}