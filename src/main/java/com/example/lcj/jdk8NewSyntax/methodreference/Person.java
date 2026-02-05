package com.example.lcj.jdk8NewSyntax.methodreference;

class Person {
    Person() { // 构造方法
        System.out.println("构造方法");
    }

    public void print(String str) { // 普通方法
        System.out.println(str);
    }

    public static void print2(String str) { // 静态方法
        System.out.println(str);
    }
}
