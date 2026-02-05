package com.example.lcj.jvm.object;

//父类
class Foo {
    int i = 1;

    Foo() {
        System.out.println(i);             //-----------(1)
        int x = getValue();
        System.out.println(x);             //-----------(2)
    }

    {
        i = 2;
    }

    protected int getValue() {
        return i;
    }
}