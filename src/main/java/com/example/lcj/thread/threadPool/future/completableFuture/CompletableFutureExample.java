package com.example.lcj.thread.threadPool.future.completableFuture;

import java.text.DecimalFormat;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing async task...");
            return "Task Result";
        });

        future.thenAccept(result -> System.out.println("Received: " + result));


        CompletableFuture.supplyAsync(() -> "Hello1")
                .thenApply(result -> result + " World1") // 转换结果
                .thenAccept(System.out::println)       // 打印结果
                .thenRun(() -> System.out.println("Done"));

        CompletableFuture.supplyAsync(() -> "Hello2")
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " World2")) // thenCompose：前后任务依赖
                .thenAccept(System.out::println);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello3");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World3");

        future1.thenCombine(future2, (result1, result2) -> result1 + " " + result2) //thenCombine：任务并行，无依赖
                .thenAccept(System.out::println);
    }

}
