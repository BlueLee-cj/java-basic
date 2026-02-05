package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：反转整数 如 123456 变成 654321 ，-123 变成 -321
 * @modified By：
 * @date ：Created in 2019/7/31 8:50
 */
public class reverseInteger {
    public static void main(String[] args) {
        int x = -123456;
        int reverse = reverse(x);
        System.out.println(reverse);
        int y = -1234569012;
        int revers = reverse(y);
        System.out.println(revers);
    }

    public static int reverse(int x) {
        int rev = 0;
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
