package com.example.lcj.thread.threadPool.userthreadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 19:36
 */
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    UserThreadFactory(String whatFectureOfGroup) {
        namePrefix = "UserThreadFactory's " + whatFectureOfGroup
                + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(task, name);
        System.out.println(thread.getName());
        return thread;
    }
}
