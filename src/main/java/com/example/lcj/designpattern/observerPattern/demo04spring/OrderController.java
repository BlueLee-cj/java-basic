package com.example.lcj.designpattern.observerPattern.demo04spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单操作，业务伪代码
 */
@RestController
public class OrderController {
    
    // 注入事件发布器
    @Autowired
   private OrderService orderService;

    /**
     * 电商 - 新订单订单
     */
    @GetMapping("/saveOrder")
    public void saveOrder() throws InterruptedException {
        System.out.println("新订单哦");
        orderService.saveOrder();
    }
}