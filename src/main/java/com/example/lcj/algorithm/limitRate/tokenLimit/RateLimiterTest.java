package com.example.lcj.algorithm.limitRate.tokenLimit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final int THREAD_COUNT = 25;

    @Test
    public void testRateLimiter1() {
        RateLimiter rateLimiter = RateLimiter.create(5);

        Thread[] ts = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            ts[i] = new Thread(new RateLimiterThread(rateLimiter), "RateLimiterThread-" + i);
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            ts[i].start();
        }

        for (;;) {}
    }

    public class RateLimiterThread implements Runnable {

        private RateLimiter rateLimiter;

        public RateLimiterThread(RateLimiter rateLimiter) {
            this.rateLimiter = rateLimiter;
        }

        @Override
        public void run() {
            rateLimiter.acquire(1);

            System.out.println(Thread.currentThread().getName() + "获取到了令牌，时间 = " + FORMATTER.format(new Date()));
        }

    }

    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(10);
        int i = 0;
        do {
            limiter.acquire();
            i++;
            System.out.println(FORMATTER.format(new Date()));
        } while (i<10);
    }

}
