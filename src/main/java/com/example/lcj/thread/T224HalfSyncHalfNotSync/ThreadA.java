package com.example.lcj.thread.T224HalfSyncHalfNotSync;

import com.example.lcj.thread.T217ExceptionThrowLock.Service;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:59
 */
public class ThreadA extends Thread {
    private Task task;

    public ThreadA(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.doLongTimeTask();
    }
}
