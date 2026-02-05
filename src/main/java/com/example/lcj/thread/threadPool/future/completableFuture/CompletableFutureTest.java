package com.example.lcj.thread.threadPool.future.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author lichengjian
 * @date 2022/9/21
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method();
    }

    public static void method() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> print());
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        String result = completableFuture.get();
        System.out.println(result);
    }

    public static String print() {
        return "sss";
    }
}
