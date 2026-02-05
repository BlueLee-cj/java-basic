package com.example.lcj.base.basetype;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/2/6 14:52
 */
public class FloatTest {
    public static void main(String[] args) {
        float a = 1f;
        float b = 0.9f;
        // 0.100000024
        float c = 0.1f;
        float d = 0.1f;
        float v = a - b;
        System.out.println(v);
        System.out.println(c == v);
        System.out.println(c == d);
        System.out.println(Float.compare(c, v));
    }
}
