package com.example.lcj.thread.T01threadOrRunnble;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/17 9:10
 */
public class Apple implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "吃了编号为：" + num-- + "的苹果");
            }
        }
    }
}
