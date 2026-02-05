package com.example.lcj.jvm.clinit.demo02;

class Foo {
    int i = 1;

    Foo() {
        System.out.println(i);             
        int x = getValue();
        System.out.println(x);            
    }

    {
        i = 2;
    }

    protected int getValue() {
        return i;
    }
}
