package com.example.lcj.thread.threadPool.future.guava;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ListenableFutureExample {
    public static void main(String[] args) {
        // 创建一个线程池
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

        // 提交任务并返回 ListenableFuture
        ListenableFuture<String> future = service.submit(() -> {
            Thread.sleep(2000); // 模拟耗时任务
            if(true){
                throw new RuntimeException();
            }
            return "Task Result";
        });

        // 添加回调函数
        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Task succeeded with result: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println("Task failed: " + t.getMessage());
            }
        }, service);

        // 关闭线程池
//        service.shutdown();
        System.out.println("Task end");
    }
}
