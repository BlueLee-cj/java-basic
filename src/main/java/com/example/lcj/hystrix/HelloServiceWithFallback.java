package com.example.lcj.hystrix;

import org.springframework.stereotype.Service;

import com.google.common.base.Stopwatch;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lichengjian
 * @date 2022/4/8
 */
@Service
@Slf4j
public class HelloServiceWithFallback {

    @HystrixCommand(commandKey = "hello", fallbackMethod = "fallback", threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "2"), // 线程核心数目
            @HystrixProperty(name = "maxQueueSize", value = "3") // 线程池队列大小
    }, commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"), // 使用线程池隔离
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"), // hystrix 超时时间
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3") // 窗口时间内多少个请求失败了，会打开断路器
    })
    public String hello(String name) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        // Random random = new Random();
        // int r = random.nextInt(3000);
        Thread.sleep(1200);
        log.info("服务耗时：{}", stopwatch.stop());
        if (true) {

            throw new RuntimeException("exception");
        }
        return "hello world!" + name;
    }

    /**
     * 错误回调方法参数签名必须与原方法一致
     *
     * @param name
     * @return
     */
    public String fallback(String name, Throwable e) {
        log.info("这是造成服务降级的异常信息：{}", name, e);
        return "this is fallback message! ";
    }
}
