package com.example.lcj.jvm.initTime;

public class ConstClass{

    static{
        System.out.println("ConstClass init!");
    }

    public static  final String CONSTANT = "hello world";
}