package com.example.lcj.base.compileandrun;

public class Test {
    static final int a = 10;

    static final int b = 20;

    static int c = 10;

    static int d = 20;

    public static void main(String[] args) {
        int num1 = a * b;    // 第一行

        int num2 = c * d;    //第二行

    }

}

//java编译时会做一些优化操作。第一行，因为是两个常量做运算，那么他们的结果就是确定的，即num1的值是确定的。
//
//        所以在编译时，编译器就会直接算出num1的值。第二行则不会，java在运行时期才为变量分配内存空间。
//
//        所以反编译后可以得到如下代码：
//
//public static void main (String [] args){
//        int num1=200;
//
//        int num2=c*d;
//
//        }