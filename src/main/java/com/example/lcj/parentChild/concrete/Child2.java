package com.example.lcj.parentChild.concrete;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/3 11:39
 */
public class Child2 extends Parent {
    public static void main(String[] args) {
        Child2 child2 = new Child2();
        child2.methodA();
    }

    public void methodB() {
        System.out.println("child2 B");
    }
}
