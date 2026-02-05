package com.example.lcj.base.finaltest;

import com.example.lcj.base.MyClass;

public class testFinal01 {
    public static void main(String[] args) {
        com.example.lcj.base.MyClass myClass1 = new com.example.lcj.base.MyClass();
        com.example.lcj.base.MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
    }
}
