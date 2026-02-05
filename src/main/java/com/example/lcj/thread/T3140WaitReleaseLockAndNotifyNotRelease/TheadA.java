package com.example.lcj.thread.T3140WaitReleaseLockAndNotifyNotRelease;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:22
 */
public class TheadA extends Thread {
    private Object lock;

    public TheadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
