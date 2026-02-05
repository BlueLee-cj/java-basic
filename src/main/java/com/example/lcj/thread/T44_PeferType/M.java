package com.example.lcj.thread.T44_PeferType;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/25 12:57
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收，finalize");
    }
}
