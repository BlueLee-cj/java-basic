package com.example.lcj.jvm.object.loader;

public class ConstClass{

    static{
        System.out.println("ConstClass init!");
    }

    public static  final String CONSTANT = "hello world";
}
