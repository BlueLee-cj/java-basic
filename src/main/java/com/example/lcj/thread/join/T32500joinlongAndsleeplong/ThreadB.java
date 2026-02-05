package com.example.lcj.thread.join.T32500joinlongAndsleeplong;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:41
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
//            synchronized (this){
            System.out.println("b run begin time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("b run end time = " + System.currentTimeMillis());
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void bService() {
        System.out.println("打印了bservice timer = " + System.currentTimeMillis());
    }
}
