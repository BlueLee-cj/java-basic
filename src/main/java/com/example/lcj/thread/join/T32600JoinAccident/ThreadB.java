package com.example.lcj.thread.join.T32600JoinAccident;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:41
 */
public class ThreadB extends Thread {
    @Override
    synchronized public void run() {
        try {
            System.out.println("b run begin time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("b run end time = " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
