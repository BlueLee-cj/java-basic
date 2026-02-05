package com.example.lcj.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NumUtil {
    public static int addNum = 0;

    public static int add10(int num) {
        addNum = num;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addNum + 10;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() -> {
                System.out.println(num + " " + NumUtil.add10(num));
            });
        }
        service.shutdown();
    }
}
