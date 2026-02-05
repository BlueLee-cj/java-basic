package com.example.lcj.thread.threadPool.userthreadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 19:45
 */
public class UserRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected. " + executor.toString());
    }
}
