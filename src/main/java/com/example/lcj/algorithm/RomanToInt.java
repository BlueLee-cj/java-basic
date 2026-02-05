package com.example.lcj.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lcj
 * @description：罗马转整数
 * @modified By：
 * @date ：Created in 2019/8/2 8:07
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(methodA("CDX"));
        System.out.println(methodA("III"));
        System.out.println(methodA("IV"));
    }

    public static int methodA(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))) {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}
