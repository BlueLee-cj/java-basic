package com.example.lcj.limitrate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @author lichengjian
 * @date 2021/10/21
 */
public class TokenTest {
    public static void main1(String[] args) throws ExecutionException {
        LoadingCache<Long, AtomicLong> counter = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS)
                .build(new CacheLoader<Long, AtomicLong>() {

                    @Override
                    public AtomicLong load(Long secend) throws Exception {
                        // TODO Auto-generated method stub
                        return new AtomicLong(0);
                    }
                });
        counter.get(1L).incrementAndGet();
    }

    public static void main2(String[] args) {
        // RateLimiter.create(2)每秒产生的令牌数
        RateLimiter limiter = RateLimiter.create(2);
        // limiter.acquire() 阻塞的方式获取令牌
        System.out.println(limiter.acquire());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());

        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
    }

    public static void main(String[] args) {
        // 平滑限流，从冷启动速率（满的）到平均消费速率的时间间隔
        RateLimiter limiter = RateLimiter.create(2, 1000L, TimeUnit.MILLISECONDS);
        System.out.println(limiter.acquire());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());

        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
    }
}
