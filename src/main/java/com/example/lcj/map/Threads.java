package com.example.lcj.map;

import java.util.HashMap;

public class Threads implements Runnable {

    private static HashMap<Integer, Integer> stringObjectHashMap = new HashMap<Integer, Integer>();

    private String threadName;

    public Threads(String threadName) {
        super();
        this.threadName = threadName;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i <= 10;i++) {
            stringObjectHashMap.put(i,i+1);
        }
    }

    public static void main(String[] args) {
        Threads t1 = new Threads("张三线程");
        Thread t11 = new Thread(t1);
        t11.start();


        Threads t2 = new Threads("李四线程");
        Thread t21 = new Thread(t2);
        t21.start();
    }

}
