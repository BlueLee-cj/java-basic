package com.example.lcj.thread.threadPool.DIYpool;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    /**
     * 利用阻塞队列实现生产者-消费者模式
     */
    BlockingQueue<Runnable> workQueue;

    /**
     * 保存内部工作线程
     */
    List<WorkThread> workThreadList = new ArrayList<>();

    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i = 0; i < poolSize; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            workThreadList.add(workThread);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5);
        MyThreadPool pool = new MyThreadPool(2, workQueue);
        for (int i = 0; i < 10; i++) {
            int num = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName()+ "线程 " + num + " 执行");
            });
        }
    }

    void execute(Runnable command) throws InterruptedException {
        // 放入任务，如果没有空间，则阻塞等待
        // try catch部分省略
        workQueue.put(command);
    }

    class WorkThread extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            // 循环取任务并执行
            while (true) {
                Runnable task = null;
                // 获取阻塞队列的第一个任务，并删除
                // 如果没有元素，则会阻塞等待
                // try catch部分省略
                task = workQueue.take();
                task.run();
            }
        }
    }
}