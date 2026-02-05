package com.example.lcj.algorithm.limitRate.CountLimit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountIndex {
    private LimitService limitService = new LimitService();

    // 计算器限流
    @RequestMapping("/CountLimiter")
    public Object searchCustomerInfoByCountLimiter() {
        // 1秒内限流个数为60
        boolean limit = limitService.limit(10, 60);
        if (!limit) {
            System.out.println("稍后再试计算器限！");
            return "稍后再试计算器限！";
        }
        // 2.如果没有达到限流的要求,直接调用接口查询
        System.out.println("成功计算器限");
        return "成功计算器限";
    }

}
