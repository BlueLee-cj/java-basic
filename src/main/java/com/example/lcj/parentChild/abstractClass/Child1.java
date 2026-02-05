package com.example.lcj.parentChild.abstractClass;

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

    @Override
    public void methodB() {
        System.out.println("chile A");
    }
}
