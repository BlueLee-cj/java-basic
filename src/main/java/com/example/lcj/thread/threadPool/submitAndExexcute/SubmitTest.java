package com.example.lcj.thread.threadPool.submitAndExexcute;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ExecutorService service = Executors.newFixedThreadPool(1);
        // Runnable r = () -> System.out.println(1 / 0);
        // service.submit(r);
        // service.shutdown();


        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = () -> {
            System.out.println("a");
            System.out.println(1 / 0);
        };
        Future f = service.submit(r);
        f.get();
        service.shutdown();
    }
}


