package com.example.lcj.thread.T10priority;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:01
 */
public class ThreadB extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}
