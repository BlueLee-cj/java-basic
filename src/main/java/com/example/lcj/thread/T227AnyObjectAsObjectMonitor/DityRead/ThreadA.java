package com.example.lcj.thread.T227AnyObjectAsObjectMonitor.DityRead;

import com.example.lcj.thread.T227AnyObjectAsObjectMonitor.Service;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:59
 */
public class ThreadA extends Thread {
    private MyOneList list;

    public ThreadA(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            MyService myService = new MyService();
            myService.addServiceMethod(list, "B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
