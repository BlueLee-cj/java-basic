package com.example.lcj.thread.threadPool.future.completableFuture;

import java.util.concurrent.*;

public class CompletableFutureTest2 {

    public static void main1(String[] args) throws Exception {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-女神：我开始化妆了，好了我叫你。");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "化妆完毕了。";
        });

        completableFuture.whenComplete((returnStr, exception) -> {
            if (exception == null) {
                System.out.println(Thread.currentThread().getName() + returnStr);
            } else {
                System.out.println(Thread.currentThread().getName() + "女神放你鸽子了。");
                exception.printStackTrace();
            }
        });
        System.out.println(Thread.currentThread().getName() + "-等女神化妆的时候可以干点自己的事情。");
        Thread.currentThread().join();
    }

    public static void main2(String[] args) throws Exception {
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-女神：我开始化妆了，好了我叫你。");
            throw new RuntimeException("男神约我看电影了，我们下次再约吧，你是个好人。");
        }).handleAsync((result, exception) -> {
            if (exception != null) {
                System.out.println(Thread.currentThread().getName() + "-女神放你鸽子了！");
                return exception.getCause();
            } else {
                return result;
            }
        }).thenApplyAsync((returnStr) -> {
            System.out.println(Thread.currentThread().getName() + "-" + returnStr);
            return returnStr;
        });
        System.out.println(Thread.currentThread().getName() + "-等女神化妆的时候可以干点自己的事情。");
        Thread.currentThread().join();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // 模拟耗时操作
            return "Result";
        });

        String result = future.get(); // 阻塞直到结果返回
        System.out.println(result);
    }
}
