package com.example.lcj.thread.threadPool.submitAndExexcute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = () -> System.out.println(1 / 0);
        service.execute(r);
        service.shutdown();
    }
}
