package com.example.lcj.algorithm.limitRate.tokenLimit;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.RateLimiter;

@RestController
public class TokenIndex {// 令牌桶：1.0 表示 每秒中生成1个令牌存放在桶中
    RateLimiter rateLimiter = RateLimiter.create(1.0);

    // 令牌桶限流
    @RequestMapping("/RateLimiter")
    public Object searchCustomerInfoByRateLimiter() {
        // 1.限流判断
        // 如果在0.5秒内 没有获取不到令牌的话，则会一直等待
        System.out.println("生成令牌等待时间:" + rateLimiter.acquire());
        boolean acquire = rateLimiter.tryAcquire(500, TimeUnit.MILLISECONDS); // 每次发送请求，愿意等待0.5秒，如果设为1秒，每次都能查询成功，因为没秒中都会放入一个令牌到桶中
        if (!acquire) {
            System.out.println("稍后再试！");
            return "稍后再试！";
        }
        // 2.如果没有达到限流的要求,直接调用接口查询
        System.out.println("成功");
        return "成功";
    }

}