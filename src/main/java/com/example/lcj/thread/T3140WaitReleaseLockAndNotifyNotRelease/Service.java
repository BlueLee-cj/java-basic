package com.example.lcj.thread.T3140WaitReleaseLockAndNotifyNotRelease;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:20
 */
public class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait()");
                lock.wait();
                //Thread.sleep(3000);
                System.out.println("end wait()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
