package com.example.lcj.thread.T217ExceptionThrowLock;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:59
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMoethod();
    }
}
