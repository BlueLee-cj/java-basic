package com.example.lcj.thread.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lichengjian
 * @date 2022/3/5
 */
@RestController
@RequestMapping("/threadLocal")
@Slf4j
public class ThreadLocalController {
    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    @GetMapping("wrong")
    public Map wrong(@RequestParam("userId") Integer userId) {

        // 设置用户信息之前先查询一次ThreadLocal中的用户信息

        String before = Thread.currentThread().getName() + ":" + currentUser.get();

        // 设置用户信息到ThreadLocal

        currentUser.set(userId);

        // 设置用户信息之后再查询一次ThreadLocal中的用户信息

        String after = Thread.currentThread().getName() + ":" + currentUser.get();

        // 汇总输出两次查询结果

        Map result = new HashMap();

        result.put("before", before);

        result.put("after", after);

        return result;

    }

    @GetMapping("right")
    public int right() throws InterruptedException {

        // 使用一个计数器跟踪完成的任务数

        AtomicInteger atomicInteger = new AtomicInteger();

        // 创建一个具有2个核心线程、5个最大线程，使用容量为10的ArrayBlockingQueue阻塞队列作为工作队列的线程池，使用默认的AbortPolicy拒绝策略

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(

                2, 5,

                5, TimeUnit.SECONDS,

                new ArrayBlockingQueue<>(10),

                new ThreadFactoryBuilder().setNameFormat("demo-threadpool-%d").build(),

                new ThreadPoolExecutor.AbortPolicy());

        printStats(threadPool);

        // 每隔1秒提交一次，一共提交20次任务

        IntStream.rangeClosed(1, 20).forEach(i -> {

            try {

                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            int id = atomicInteger.incrementAndGet();

            try {

                threadPool.submit(() -> {

                    log.info("{} started", id);

                    // 每个任务耗时10秒

                    try {

                        TimeUnit.SECONDS.sleep(10);

                    } catch (InterruptedException e) {

                    }

                    log.info("{} finished", id);

                });

            } catch (Exception ex) {

                // 提交出现异常的话，打印出错信息并为计数器减一

                log.error("error submitting task {}", id, ex);

                atomicInteger.decrementAndGet();

            }

        });

        TimeUnit.SECONDS.sleep(60);

        return atomicInteger.intValue();

    }

    private void printStats(ThreadPoolExecutor threadPool) {

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {

            log.info("=========================");

            log.info("Pool Size: {}", threadPool.getPoolSize());

            log.info("Active Threads: {}", threadPool.getActiveCount());

            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());

            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());

            log.info("=========================");

        }, 0, 1, TimeUnit.SECONDS);

    }
}
