package com.example.lcj.jvm.object.loader;

public class StaticTest01 {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest01 st = new StaticTest01();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest01() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
    static StaticTest01 st1 = new StaticTest01();
}