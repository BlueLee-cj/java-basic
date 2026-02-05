package com.example.lcj.thread.T41100ReentrantLock;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/12 22:29
 */
public class MyThread extends Thread {
    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
