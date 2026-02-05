package com.example.lcj.algorithm;


/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/2 23:15
 */
public class LastWordLength {
    public static void main(String[] args) {
        String wr = "Hello World";
        System.out.println(methodA(wr));
        System.out.println(methodB(wr));
    }

    public static int methodA(String a) {
        int len = a.length();
        int i = a.lastIndexOf(" ");
        return len - i - 1;
    }

    public static int methodB(String a) {
        int len = a.length();
        int n = len - 1;
        while (n > 0 && a.charAt(n) != ' ') {
            n--;
        }
        return len - 1 - n;
    }
}
