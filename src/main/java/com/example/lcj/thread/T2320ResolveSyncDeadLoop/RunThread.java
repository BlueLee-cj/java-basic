package com.example.lcj.thread.T2320ResolveSyncDeadLoop;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 17:05
 */
public class RunThread extends Thread {
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void method() {
        System.out.println("快进入run了");
        while (isRunning == true) {
            System.out.println("进来了");
        }
        System.out.println("线程被停止了");
    }

    @Override
    public void run() {
        method();
    }
}
