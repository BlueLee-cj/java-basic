package com.example.lcj.thread.T03currentthreadmethod;

public class ComplexCurrentThread extends Thread {

    public ComplexCurrentThread() {
        System.out.println("构造--begin");
        System.out.println("构造打印："
                + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("构造---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("run方法打印："
                + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("run---end");
    }

    public static void main(String[] args) {
        ComplexCurrentThread c = new ComplexCurrentThread();
        Thread t1 = new Thread(c, "A");
        t1.start();
    }
}