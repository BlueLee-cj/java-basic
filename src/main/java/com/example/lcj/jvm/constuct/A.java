package com.example.lcj.jvm.constuct;

class A {
    static {
        System.out.println("Static Block A.");
    }

    {
        System.out.println("Instance Block A.");
    }

    public A() {
        System.out.println("Constructor A.");
    }

    public static void main(String[] args) {
        new A();
        /*
         * Static Block A. Instance Block A. Constructor A.16
         * */
    }
}