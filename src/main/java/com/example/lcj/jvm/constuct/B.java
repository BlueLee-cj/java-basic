package com.example.lcj.jvm.constuct;

class B extends A {
    static {
        System.out.println("Static Block B.");
    }

    {
        System.out.println("Instance Block B.");
    }

    public B() {
        System.out.println("Constructor B.");
    }

    public static void main(String[] args) {
        new A();
        /*
         * Static Block A. Static Block B. Instance Block A. Constructor A.
         */
        //System.out.println();
        new B();
        /*
         * Instance Block A. Constructor A. Instance Block B. Constructor B.
         */
        // 静态成员和静态初始化块只会执行一次。
    }
}