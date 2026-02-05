package com.example.lcj.jvm.initTime;


public class SClass extends SSClass{
    static{
        System.out.println("SClass static init");
    }

    public static int value = 123;

    public SClass(){
        System.out.println("init SClass");
    }
}