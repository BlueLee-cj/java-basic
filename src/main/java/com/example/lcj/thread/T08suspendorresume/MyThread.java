package com.example.lcj.thread.T08suspendorresume;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 15:58
 */
public class MyThread extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}
