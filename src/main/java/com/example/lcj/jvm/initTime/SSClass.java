package com.example.lcj.jvm.initTime;

public class SSClass{
    static{
        System.out.println("SSClass static init");
    }

    public SSClass(){
        System.out.println("init SSClass");
    }
}