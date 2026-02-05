package com.example.lcj.parentChild.concrete;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/3 11:39
 */
public class Child1 extends Parent {
    public static void main(String[] args) {
        Child1 child1 = new Child1();
        child1.methodA();

    }

    public void methodB() {
        System.out.println("child1 B");
    }
}
