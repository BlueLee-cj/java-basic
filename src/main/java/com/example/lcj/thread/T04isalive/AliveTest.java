package com.example.lcj.thread.T04isalive;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 14:34
 */
public class AliveTest<main> extends Thread {
    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }

    public static void main(String[] args) throws InterruptedException {
        AliveTest aliveTest = new AliveTest();
        System.out.println("begin=" + aliveTest.isAlive());
        aliveTest.start();
        Thread.sleep(1000);
        System.out.println("end=" + aliveTest.isAlive());
    }
}
