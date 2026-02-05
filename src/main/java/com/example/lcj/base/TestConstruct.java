package com.example.lcj.base;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/6/28 13:36
 */
public class TestConstruct {
    static int cnt = 6;

    static {
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println(cnt);
    }

    static {
        cnt /= 3;
    }
}
