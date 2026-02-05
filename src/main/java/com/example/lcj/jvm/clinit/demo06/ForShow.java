package com.example.lcj.jvm.clinit.demo06;

public class ForShow {
    public static void main(String[] args) {
/*
 * 静态成员变量
 * 静态代码块
 * ⾮静态成员变量
 * 构造代码块a
 * 构造代码块b
 * 构造函数
 */
        new Test1();
/*
 * ⾮静态成员变量
 * 构造代码块a
 * 构造代码块b
 * 构造函数
 */
        new Test1();
    }
}
