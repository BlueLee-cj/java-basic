package com.example.lcj.thread.blockqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author lichengjian
 * @date 2022/2/14
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(2);

        for (int i = 0; i < 30; i++) {
            // 将指定元素添加到此阻塞栈中，如果没有可用空间，将一直等待（如果有必要）。
            priorityBlockingQueue.put(i);
            System.out.println("向阻塞栈中添加了元素:" + i);
        }
        System.out.println("程序到此运行结束，即将退出----");
    }
}
