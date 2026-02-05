package com.example.lcj.tomcat;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TomcatController {

    private ExecutorService executorService = new ThreadPoolExecutor(2, 3, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadFactoryBuilder().setNameFormat("tomcat-thread-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());

    private int sum = 0;

    @GetMapping("thread")
    public String thread(@RequestParam String name) throws InterruptedException {
        log.info("thread--->{}, name-->{}, sum:{}", Thread.currentThread().getName(), name, ++sum);
        Thread.sleep(10000);
        return "success";
    }


    @GetMapping("share")
    public String share(@RequestParam String name) throws InterruptedException {
        log.info("share,thread--->{}, name-->{}, sum:{}", Thread.currentThread().getName(), name, ++sum);
        Thread.sleep(10000);
        return "success";
    }

    @GetMapping("block")
    public String block(@RequestParam String name) throws InterruptedException {
        log.info("block begin,thread--->{}, name-->{}, sum:{}", Thread.currentThread().getName(), name, ++sum);
        executorService.execute(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(" executor,thread--->{}, name-->{}, sum:{}", Thread.currentThread().getName(), name, ++sum);
        });
        log.info("block end,thread--->{}, name-->{}, sum:{}", Thread.currentThread().getName(), name, ++sum);
        Thread.sleep(15000);
        return "success";
    }
}
