package com.example.lcj.thread.T02share;

public class MyThreadNotShare extends Thread {
    private int count = 5;

    public MyThreadNotShare(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        while (count > 0) {//使用同步后其他线程就得不到运行的机会
            count--;
            System.out.println("由" + Thread.currentThread().getName() + "计算,count=" + count);
        }
    }
}
