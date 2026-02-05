package com.example.lcj.jvm.initTime;

public class SubClass extends SClass{
    static{
        System.out.println("SubClass static init");
    }

    static int a;

    final static int b = 123;

    public SubClass(){
        System.out.println("init SubClass");
    }
}