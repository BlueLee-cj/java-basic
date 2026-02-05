package com.example.lcj.designpattern.decorator.demo01;

public class Test {
    public static void main(String[] args) {
        ABattercake aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);
        // 煎饼 加一个鸡蛋 加一个鸡蛋 加一根香肠 销售价格为: 12
        System.out.println(aBattercake.getDesc() + " 销售价格为: " +
                aBattercake.cost());
    }
}