package com.example.lcj.base.generictype.method;

public class Test {

    public static <T> void f(T t) {
        System.out.println("test" + t.getClass().getName());
    }

    public static void main(String[] args) {
        f("");
        f(1);
        f(1.0f);
        f(new Object());
    }
}
