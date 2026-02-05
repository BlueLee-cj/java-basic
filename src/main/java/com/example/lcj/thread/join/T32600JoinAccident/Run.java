package com.example.lcj.thread.join.T32600JoinAccident;

import com.example.lcj.thread.join.T32500joinlongAndsleeplong.ThreadC;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:45
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);
        a.start();
        b.start();
        b.join(2000);
        System.out.println("             main  end time = " + System.currentTimeMillis());
    }
}
