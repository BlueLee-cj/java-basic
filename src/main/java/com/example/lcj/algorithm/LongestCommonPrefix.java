package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：最长公共前缀
 * @modified By：
 * @date ：Created in 2019/7/31 8:59
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] a = {"flower", "flow", "flight"};
        String prefix = methodA(a);
        System.out.println(prefix);
    }

    public static String methodA(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}

