package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：给定一个字符串 `S` ，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * 提示：
 * 1.  `S.length <= 100`
 * 2.  `33 <= S[i].ASCIIcode <= 122`
 * 3.  `S` 中不包含 `\` or `"`
 * @modified By：
 * @date ：Created in 2019/8/4 8:39
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(methodA(s));
    }

    public static String methodA(String s) {
        if (s.length() <= 1) {
            return s;
        } else {
            char[] cs = s.toCharArray();
            int x = 0;
            int y = cs.length - 1;
            while (x <= y) {
                if (!Character.isLetter(cs[x])) {
                    x++;
                } else if (!Character.isLetter(cs[y])) {
                    y--;
                } else {
                    char temp = cs[x];
                    cs[x] = cs[y];
                    cs[y] = temp;
                    x++;
                    y--;
                }
            }
            return String.valueOf(cs);
        }
    }
}
