package com.example.lcj.jvm.clinit.demo03;


public class ConstructorExample {
    public static void main(String... args) {
        //Foo foo = new Foo();
        Bar bar = new Bar();
        System.out.println(bar.getValue());
    }
}