package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/2 17:05
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "Hello";
        String needle = "ll";
        System.out.println(haystack.indexOf(needle));
        System.out.println(methodA(haystack, needle));
    }

    public static int methodA(String a, String b) {
        if (a == null || b == null || a.length() < b.length()) {
            return 0;
        }
        for (int i = 0; i <= a.length() - b.length(); i++) {
            if (a.substring(i, i + b.length()).equals(b)) {
                return i;
            }
        }
        return -1;
    }
}
