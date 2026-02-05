package com.example.lcj.thread;

public class MyThreadYield extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000; i++) {
            Thread.yield();             // �������ע�ͺ�ִ�л���
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("��ʱ��" + (endTime - beginTime) + "���룡");
    }

    public static void main(String[] args) {
        MyThreadYield thread = new MyThreadYield();
        thread.start();
    }
}