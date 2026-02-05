package com.example.lcj.thread.T3140WaitReleaseLockAndNotifyNotRelease;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:24
 */
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        TheadA a = new TheadA(lock);
        a.start();
        TheadB b = new TheadB(lock);
        b.start();
    }
}
