package com.example.lcj.designpattern.observerPattern.demo03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/30 14:35
 */
public class RealSubject implements Subject{
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyChanged() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

}
