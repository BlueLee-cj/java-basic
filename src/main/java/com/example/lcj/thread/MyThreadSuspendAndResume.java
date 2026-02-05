package com.example.lcj.thread;

public class MyThreadSuspendAndResume {

    public synchronized void printString() {        // ͬ������
        System.out.println("Thread-" + Thread.currentThread().getName() + " begins.");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("�߳�a suspend ��...");
            Thread.currentThread().suspend();
        }
        System.out.println("Thread-" + Thread.currentThread().getName() + " is end.");
    }

    public static void main(String[] args) throws InterruptedException {

        final MyThreadSuspendAndResume object = new MyThreadSuspendAndResume();     // �����߳�ʹ�ù���ͬһ������

        Thread a = new Thread("a") {
            @Override
            public void run() {
                object.printString();
            }
        };
        a.start();

        Thread b = new Thread("b") {
            @Override
            public void run() {
                System.out.println("thread2 �����ˣ��ڵȴ���(������������)...");
                object.printString();
            }
        };
        b.start();

        System.out.println("main �߳�˯�� " + 5 + " ��...");
        Thread.sleep(5000);
        System.out.println("main �߳�˯����...");

        a.resume();
        System.out.println("�߳� a resume ��...");
    }
}