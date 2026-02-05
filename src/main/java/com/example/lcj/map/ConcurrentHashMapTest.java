package com.example.lcj.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("Thread3") {
            @Override
            public void run() {
                map.put(7, 77);
            }
        };
        thread.start();
        Thread.sleep(3000);
        thread.start();
        System.out.println(map);
        map.put(null, null);
    }
}
