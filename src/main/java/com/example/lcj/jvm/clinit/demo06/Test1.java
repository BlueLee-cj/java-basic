package com.example.lcj.jvm.clinit.demo06;

public class Test1 {
    public static Parameter parameter1 = new Parameter("静态成员变量");
    public Parameter parameter2 = new Parameter("⾮静态成员变量");

    public Test1() {
        System.out.println("构造函数");
    }

    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("构造代码块a");
    }
    {
        System.out.println("构造代码块b");
    }
}
