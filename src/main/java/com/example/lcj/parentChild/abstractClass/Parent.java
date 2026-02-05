package com.example.lcj.parentChild.abstractClass;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/3 11:38
 */
public abstract class Parent {
    public void methodA() {
        System.out.println("parent A begin");
        methodB();
        System.out.println("parent A end");
    }

    public abstract void methodB();
}
