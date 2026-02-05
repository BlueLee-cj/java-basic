package com.example.lcj.algorithm.limitRate.CountLimit;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chris
 * @see 计数器实现限流 每分钟只允许10个请求
 *      第一个请求进去的时间为startTime,在startTime + 60s内只允许10个请求
 *      当60s内超过十个请求后，拒绝，不超过，到第60s 重新设置时间
 */
@Setter
@Getter
public class LimitService {
    // 限流的个数
    private int maxCount = 10;
    // 指定的时间内
    private long interval = 60;
    // 原子类计数器
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    // 起始时间
    private long startTime = System.currentTimeMillis();

    public boolean limit(int maxCount, int interval) {
        atomicInteger.addAndGet(1);
        if (atomicInteger.get() == 1) {
            startTime = System.currentTimeMillis();
            atomicInteger.addAndGet(1);
            return true;
        }
        // 超过了间隔时间，直接重新开始计数
        if (System.currentTimeMillis() - startTime > interval * 1000) {
            startTime = System.currentTimeMillis();
            atomicInteger.set(1);
            return true;
        }
        // 还在间隔时间内,check有没有超过限流的个数
        if (atomicInteger.get() > maxCount) {
            return false;
        }
        return true;
    }
}
