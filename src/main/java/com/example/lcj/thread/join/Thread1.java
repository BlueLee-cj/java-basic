package com.example.lcj.thread.join;


class Thread1 extends Thread {
    private String name;

    public Thread1(String name) {
        super(name);
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始运行!");
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + name + " : " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "运行结束!");
    }

    public static void main(String[] args) {
        //m1();
        m2();
    }

    public static void m1() {
        System.out.println(Thread.currentThread().getName() + "开始运行!");
        Thread1 mTh1 = new Thread1("A");
        Thread1 mTh2 = new Thread1("B");
        mTh1.start();
        mTh2.start();
        System.out.println(Thread.currentThread().getName() + "运行结束!");

    }

    public static void m2() {
        System.out.println(Thread.currentThread().getName() + "开始运行!");
        Thread1 mTh1 = new Thread1("A");
        Thread1 mTh2 = new Thread1("B");
        mTh1.start();
        mTh2.start();
        try {
            mTh1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束!");

    }
}
