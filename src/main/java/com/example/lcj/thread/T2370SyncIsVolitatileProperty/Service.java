package com.example.lcj.thread.T2370SyncIsVolitatileProperty;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 20:10
 */
public class Service {
    private static boolean isContinueRun = true;

    public void runMethod() {
        while (isContinueRun == true) {
            //System.out.println("停不下来");
        }
        System.out.println("停下来了");
    }

    public void stopMethod() {
        isContinueRun = false;
    }
}
