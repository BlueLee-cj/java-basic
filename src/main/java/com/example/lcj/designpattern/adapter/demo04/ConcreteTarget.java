package com.example.lcj.designpattern.adapter.demo04;

public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("I have nothing to do. if you need any help,pls call me!");
    }

}
