package com.example.lcj.thread.T2320ResolveSyncDeadLoop;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 17:05
 */
public class PrintString implements Runnable {
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                Thread.sleep(100);
            }
            System.out.println("结束了 threadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}
