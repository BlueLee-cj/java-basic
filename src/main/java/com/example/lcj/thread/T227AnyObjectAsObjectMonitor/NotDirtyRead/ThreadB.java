package com.example.lcj.thread.T227AnyObjectAsObjectMonitor.NotDirtyRead;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:59
 */
public class ThreadB extends Thread {
    private MyOneList list;

    public ThreadB(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            MyService myService = new MyService();
            myService.addServiceMethod(list, "A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
