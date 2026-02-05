package com.example.lcj.base;

public class TestB extends TestA {
    static {
        System.out.println("static B");
    }

    {
        System.out.println("B class");
    }

    public TestB() {
        System.out.println("TestB");
    }

    public static void main(String[] args) {
        System.out.println("start");
        new TestB();
        System.out.println("end");
    }
}
