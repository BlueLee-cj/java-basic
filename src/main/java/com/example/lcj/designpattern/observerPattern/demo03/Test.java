package com.example.lcj.designpattern.observerPattern.demo03;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/30 14:36
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Observer observer = new RealObject();
        subject.attach(observer);
        subject.notifyChanged();
    }
}
