package com.example.lcj.thread.T11shouhuThread;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:08
 */
public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            try {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
