package com.example.lcj.thread.T2370SyncIsVolitatileProperty.demo;


/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:59
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}
