package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description： 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 `1` 和 `0` 。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * @date ：Created in 2019/8/3 6:54
 */
public class TwoBinary {
    public static void main(String[] args) {
        String a = "111";
        String b = "111";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        //表示向前进一位
        int pre = 0;

        while (a.length() != b.length()) {
            if (a.length() > b.length())
                b = "0" + b;
            else
                a = "0" + a;
        }

        for (int i = a.length() - 1; i >= 0; i--) {
            int m = a.charAt(i) - '0';
            int n = b.charAt(i) - '0';
            int temp = m + n + pre;
            if (temp >= 2) {
                sb.append(temp - 2);
                pre = 1;
            } else {
                sb.append(temp);
                pre = 0;
            }
        }

        if (pre == 1)
            sb.append('1');

        return sb.reverse().toString();


    }
}
