package com.example.lcj.designpattern.observerPattern.demo01push;

/**
 * 主题
 */
public interface Subject {

    // 添加观察者
    void registerObserver(Observer o);

    // 删除观察者
    void removeObserver(Observer o);

    // 通知
    void notifyObservers();
}