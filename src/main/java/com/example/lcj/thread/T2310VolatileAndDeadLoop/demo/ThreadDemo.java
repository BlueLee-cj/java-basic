package com.example.lcj.thread.T2310VolatileAndDeadLoop.demo;

/**
 * @author Dongguabai
 * @description volatile 线程可见性
 * @date 2019/1/7 13:21
 */
public class ThreadDemo extends Thread {

    private Boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo t = new ThreadDemo();
        t.start();
        Thread.sleep(1000);
        t.stopMe();
    }

    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println(i);
    }

    public void stopMe() {
        System.out.println(" STOP--------");
        this.stop = true;
    }
}
