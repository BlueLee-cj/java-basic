package com.example.lcj.jvm.GC;

public class GCMain {
    static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        sleep(20);

        for (int i = 0; i < 100; i++) {
            loadData(i);
        }
    }

    // loadData 每次请求产生20M对象，每次请求耗时1秒
    public static void loadData(int index) {
        System.out.println("load data: " + index);
        byte[] data1 = new byte[_1M * 10];
        byte[] data2 = new byte[_1M * 10];

        sleep(1);
    }

    public static void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
