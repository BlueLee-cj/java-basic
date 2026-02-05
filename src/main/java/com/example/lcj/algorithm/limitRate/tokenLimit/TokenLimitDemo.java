package com.example.lcj.algorithm.limitRate.tokenLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;

/**
 * @author ：lcj
 * @description：
 * 令牌桶算法可以说是对漏桶算法的改进。漏桶算法能限制请求的速率。而令牌桶算法在限制请求速率的
 * 同时还允许一定程度的突发调用
 * 过程如下
 * 1. 一直放令牌，如果令牌桶达到上限则丢弃令牌，假设每秒放10个
 * 2. 可以应对一定程度的流量激增，如此时令牌桶有100个令牌，突然发生200次调用，则此时最开始
 * 的100次请求可以正常调用，后续的请求才会以10个/s的速率来调用
 * 实现：用队列保存令牌，用ScheduledThreadPoolExecutor来定时放令牌
 * rateLimiter提供了acquire()和tryAcquire()方法
 * 1. acquire()方法，如果没有可用令牌，会一直阻塞到获得令牌
 * 2. tryAcquire()方法，如果没有可用令牌，则直接返回false，可以设置超时获取
 * @date ：Created in 2020/11/24 14:17
 */
public class TokenLimitDemo {
    public static void main(String[] args) {
        // 每秒生成2个令牌
        RateLimiter rateLimiter = RateLimiter.create(2);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                // 获得令牌
                double acquire = rateLimiter.acquire();
                System.out.println(LocalDateTime.now());
            }).start();
        }
    }
}
