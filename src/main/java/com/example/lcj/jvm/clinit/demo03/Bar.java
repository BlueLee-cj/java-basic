package com.example.lcj.jvm.clinit.demo03;

//子类
class Bar extends Foo {
    int j = 2;
    @Override
    protected int getValue() {
        return j;
    }
}
