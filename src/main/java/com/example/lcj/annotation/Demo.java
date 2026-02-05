package com.example.lcj.annotation;

/**
 * @author lichengjian
 * @date 2021/10/14
 */
public class Demo {
    public String name;

    @Ano(getValue = "ano on method")
    public void hello() {};

    public void defaultMethod() {}

    public void repet() {}

    public static void main(String[] args) {
        Demo demo = new Demo();
    }
}
