package com.example.lcj.reflect.DynamicLoad;

public class A {
    public static void main(String[] args) {
        if ("B".equals(args[0])) {
            B b = new B();
            b.start();
        }
//        if ("C".equals(args[0])) {
//            C c = new C();
//            C.start();
//        }
    }
}
