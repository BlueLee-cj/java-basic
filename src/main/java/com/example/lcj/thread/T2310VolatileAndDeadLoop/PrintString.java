package com.example.lcj.thread.T2310VolatileAndDeadLoop;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.logging.Logger;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 17:05
 */
public class PrintString {
    private volatile boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void stopPrint() {
        isContinuePrint = false;
    }

    public void printStringMethod() {
        int i = 0;
        try {
            while (isContinuePrint == true) {
                //System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                //Thread.sleep(1000);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("停止了i=" + i);
    }

}
