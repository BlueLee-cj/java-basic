package com.example.lcj.algorithm.timedtask.timewheel.hash;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;

public class HashedWheelTimerTest {

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    @Test
    public void test1() throws Exception {

        // 定义一个HashedWheelTimer，有16个格的轮子，每一秒走一个一个格子
        HashedWheelTimer timer = new HashedWheelTimer(1, TimeUnit.SECONDS, 16);

        System.out.println("task    begin ----- " + System.currentTimeMillis());

        // 把任务加到HashedWheelTimer里，到了延迟的时间就会自动执行
        timer.newTimeout(timeout -> {
            System.out.println("task1 execute ----- " + System.currentTimeMillis());
            countDownLatch.countDown();
        }, 500, TimeUnit.MILLISECONDS);

        timer.newTimeout(timeout -> {
            System.out.println("task2 execute ----- " + System.currentTimeMillis());
            countDownLatch.countDown();
        }, 2, TimeUnit.SECONDS);

        countDownLatch.await();
        System.out.println("task      end ----- " + System.currentTimeMillis());
        timer.stop();
    }

    public static void main(String[] args) {
        // 构造一个 Timer 实例
        Timer timer = new HashedWheelTimer();

        // 提交一个任务，让它在 5s 后执行
        Timeout timeout1 = timer.newTimeout(timeout -> {
            System.out.println("5s 后执行该任务");
        }, 5, TimeUnit.SECONDS);

        // 再提交一个任务，让它在 10s 后执行
        Timeout timeout2 = timer.newTimeout(timeout -> {
            System.out.println("10s 后执行该任务");
        }, 10, TimeUnit.SECONDS);

        // 取消掉那个 5s 后执行的任务
        if (!timeout1.isExpired()) {
            timeout1.cancel();
        }

        // 原来那个 5s 后执行的任务，已经取消了。这里我们反悔了，我们要让这个任务在 3s 后执行
        // 我们说过 timeout 持有上、下层的实例，所以下面的 timer 也可以写成 timeout1.timer()
        timer.newTimeout(timeout1.task(), 3, TimeUnit.SECONDS);
    }
}
