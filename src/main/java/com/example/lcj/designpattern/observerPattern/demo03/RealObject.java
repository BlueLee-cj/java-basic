package com.example.lcj.designpattern.observerPattern.demo03;

public class RealObject implements Observer {
    @Override
    public void update() {
        System.out.println("接收到了通知");
    }
}
