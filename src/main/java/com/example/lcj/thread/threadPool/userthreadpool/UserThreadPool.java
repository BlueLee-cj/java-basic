package com.example.lcj.thread.threadPool.userthreadpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 19:35
 */
public class UserThreadPool {
    public static void main(String[] args) {
        BlockingDeque queue = new LinkedBlockingDeque<>(2);
        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");
        UserRejectHandler userRejectHandler = new UserRejectHandler();
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, f1, userRejectHandler);
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, queue, f2, userRejectHandler);
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
