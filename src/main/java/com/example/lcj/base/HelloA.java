package com.example.lcj.base;

public class HelloA {
    public HelloA() {//构造函数
        System.out.println("A的构造函数");
    }

    {//构造代码块
        System.out.println("A的构造代码块");
    }

    static {//静态代码块
        System.out.println("A的静态代码块");
    }

    public static void main(String[] args) {
        HelloA a = new HelloA();
        HelloA b = new HelloA();
    }
}