package com.example.lcj.thread.syncsample;


/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/17 11:28
 */
public class Plate {
    private int count;
    public final int MAX_COUNT = 3;

    public synchronized void get() {
        if (count > 0) {
            count--;
            Thread.currentThread().yield();
            System.out.println(Thread.currentThread().getName() + "取出第" + (MAX_COUNT - count) + "个桃子");
        } else {
            System.out.println(Thread.currentThread().getName() + "没有桃子");
        }
    }

    public synchronized void put() {
        if (count == 0) {
            count = MAX_COUNT;
            Thread.currentThread().yield();
            System.out.println(Thread.currentThread().getName() + "给果盘装满" + count + "个桃子");
        }
    }
}
