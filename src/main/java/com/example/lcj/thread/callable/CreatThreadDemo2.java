package com.example.lcj.thread.callable;

public class CreatThreadDemo2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("线程执行了...");
        }
    }

    public static void main(String[] args) {
        //将线程任务传给线程对象
        Thread thread = new Thread(new CreatThreadDemo2());
        //启动线程
        thread.start();
    }
}