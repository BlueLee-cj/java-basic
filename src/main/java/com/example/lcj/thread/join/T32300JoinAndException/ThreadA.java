package com.example.lcj.thread.join.T32300JoinAndException;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:41
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String s = new String();
            System.out.println(Math.random());
        }
    }
}
