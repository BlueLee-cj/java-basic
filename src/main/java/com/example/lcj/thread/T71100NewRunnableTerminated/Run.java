package com.example.lcj.thread.T71100NewRunnableTerminated;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/8 19:05
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread t = new MyThread();
            System.out.println("main 方法中状态1：" + t.getState());
            Thread.sleep(1000);

            t.start();
            Thread.sleep(1000);
            System.out.println("main 方法中的状态2：" + t.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
