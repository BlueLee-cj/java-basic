package com.example.lcj.base;

public class TestA {
    static {
        System.out.println("static A");
    }

    {
        System.out.println("A class");
    }

    public TestA() {
        System.out.println("TestA");
    }
}
