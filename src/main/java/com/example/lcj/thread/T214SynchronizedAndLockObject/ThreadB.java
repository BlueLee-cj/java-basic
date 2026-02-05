package com.example.lcj.thread.T214SynchronizedAndLockObject;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:28
 */
public class ThreadB extends Thread {
    private MyObject object;

    public ThreadB(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
