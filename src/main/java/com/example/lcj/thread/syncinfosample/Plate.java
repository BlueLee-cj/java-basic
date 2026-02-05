package com.example.lcj.thread.syncinfosample;


/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/17 11:28
 */
public class Plate {
    private int count;
    public final int MAX_COUNT = 3;

    public synchronized void get() {
        this.notifyAll();
        while (count == 0) {
            System.out.println(Thread.currentThread().getName() + ":wait");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Thread.currentThread().yield();
        System.out.println(Thread.currentThread().getName() + "取出第" + (MAX_COUNT - count) + "个桃子");
    }

    public synchronized void put() {
        this.notifyAll();

        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + ":wait");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count = MAX_COUNT;
        Thread.currentThread().yield();
        System.out.println(Thread.currentThread().getName() + "给果盘装满" + count + "个桃子");
    }
}
