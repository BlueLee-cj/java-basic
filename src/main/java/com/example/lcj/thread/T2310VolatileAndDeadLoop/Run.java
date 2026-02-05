package com.example.lcj.thread.T2310VolatileAndDeadLoop;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 17:08
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        //printString.printStringMethod();
        ThreadA thread = new ThreadA(printString);
        thread.start();
        Thread.sleep(2000);
        System.out.println("我要停止他！stpThread=" + Thread.currentThread().getName());
        //ThreadB threadb = new ThreadB(printString);
        //threadb.start();
        printString.setContinuePrint(false);
    }
}
