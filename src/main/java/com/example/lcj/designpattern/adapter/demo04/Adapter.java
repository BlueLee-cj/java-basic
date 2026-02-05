package com.example.lcj.designpattern.adapter.demo04;

public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        super.doSomething();
    }

}
