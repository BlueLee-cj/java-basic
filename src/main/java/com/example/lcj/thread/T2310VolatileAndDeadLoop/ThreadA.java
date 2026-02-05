package com.example.lcj.thread.T2310VolatileAndDeadLoop;


import com.example.lcj.thread.T2370SyncIsVolitatileProperty.demo.Service;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:59
 */
public class ThreadA extends Thread {
    private PrintString printString;

    public ThreadA(PrintString printString) {
        this.printString = printString;
    }

    @Override
    public void run() {
        printString.printStringMethod();
    }
}
