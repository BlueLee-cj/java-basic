package com.example.lcj.thread.T71100NewRunnableTerminated;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/8 19:00
 */
public class MyThread extends Thread {
    public MyThread() {
        System.out.println("构造方法中的状态：" + Thread.currentThread().getState() + "线程名字：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run 方法中的状态：" + Thread.currentThread().getState() + "线程名字：" + Thread.currentThread().getName());
    }
}
