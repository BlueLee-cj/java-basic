package com.example.lcj.thread.join.T32300JoinAndException;

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
            ThreadA a = new ThreadA();
            a.start();
            a.join();
            System.out.println("线程b在run end处打印了");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程b在catch处打印了");
        }
    }
}
