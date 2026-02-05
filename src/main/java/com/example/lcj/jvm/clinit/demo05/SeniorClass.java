package com.example.lcj.jvm.clinit.demo05;

public class SeniorClass {
    public SeniorClass() {
        System.out.println("父类构造方法");
        toString();                   //父类的构造方法调用toString()
    }

    public String toString() {
        System.out.println("Senior");
        return "Senior";
    }
}