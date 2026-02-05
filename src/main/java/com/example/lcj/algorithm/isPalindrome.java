package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：是否是回文数
 * @modified By：
 * @date ：Created in 2019/7/31 11:26
 */
public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(methodA(1234321));
        System.out.println(methodB(1234221));
    }

    public static boolean methodA(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        int y = x;
        int tmp = 0;
        while (y != 0) {
            tmp = tmp * 10 + y % 10;
            y /= 10;
        }
        return tmp == x;
    }

    public static boolean methodB(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if(chars[i] != chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
