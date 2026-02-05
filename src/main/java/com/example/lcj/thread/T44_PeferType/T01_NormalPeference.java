package com.example.lcj.thread.T44_PeferType;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/25 12:57
 */
public class T01_NormalPeference {
    public static void main(String[] args) {
        M m = new M();
        m = null;
        System.gc();
    }
}
