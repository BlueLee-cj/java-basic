package com.example.lcj.thread.T214SynchronizedAndLockObject.SameObjectDifferentSychMethod;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:28
 */
public class ThreadA extends Thread {
    private MyObject object;

    public ThreadA(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
