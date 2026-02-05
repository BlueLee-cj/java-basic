package com.example.lcj.thread.T2320ResolveSyncDeadLoop;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 17:08
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        RunThread runThread = new RunThread();
//        new Thread(runThread).start();
        runThread.start();
        Thread.sleep(1000);
        runThread.setRunning(false);
        System.out.println("已经被赋值为false");
    }
}
