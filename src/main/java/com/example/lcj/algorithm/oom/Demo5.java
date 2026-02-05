package com.example.lcj.algorithm.oom;

//面向对象思想实现篮子物品交换
public class Demo5 {
    public static void main(String[] args) {
        //创建篮子
        Basket A = new Basket("A");
        Basket B = new Basket("B");
        //装载物品
        A.load("鸡蛋");
        B.load("苹果");
        //交换物品
        A.change(B);
        A.show();
        B.show();
    }
}