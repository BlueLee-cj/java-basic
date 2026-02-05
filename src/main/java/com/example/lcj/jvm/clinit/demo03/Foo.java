package com.example.lcj.jvm.clinit.demo03;

class Foo {
    int i = 1;

    public Foo() {
        System.out.println(getValue());
    }

    protected int getValue() {
        return i;
    }
}
