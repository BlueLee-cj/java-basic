package com.example.lcj.designpattern.decorator.demo01;

// 具体组件实现类
public class Battercake extends ABattercake {

    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}