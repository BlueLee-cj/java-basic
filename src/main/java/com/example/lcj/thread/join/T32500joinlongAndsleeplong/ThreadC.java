package com.example.lcj.thread.join.T32500joinlongAndsleeplong;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:41
 */
public class ThreadC extends Thread {
    private ThreadB threadB;

    public ThreadC(ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
        threadB.bService();
    }
}
