package com.example.lcj.base.finaltest;

public class TestFinal {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));

        String f = "hello2";
        String g = "hello" + "2";
        System.out.println((f == g));
    }
}





