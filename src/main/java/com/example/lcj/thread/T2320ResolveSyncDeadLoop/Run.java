package com.example.lcj.thread.T2320ResolveSyncDeadLoop;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 17:08
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        Thread.sleep(1000);
        System.out.println("我要停止他！stpThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
