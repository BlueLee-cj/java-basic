package com.example.lcj.designpattern.observerPattern.demo01push;

/**
 * 观察者超类
 */
public interface Observer {

    public void update(float temp, float humidity, float pressure);
}