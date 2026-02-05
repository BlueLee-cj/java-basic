package com.example.lcj.designpattern.observerPattern.demo04spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单操作，业务伪代码
 */
@Service
public class OrderService {
    
    // 注入事件发布器
    @Autowired
   private OrderPublish orderPublish;

    /**
     * 电商 - 新订单订单
     */
    public void saveOrder() throws InterruptedException {

        System.out.println("1、 订单创建成功");

        // 创建事件 ，可以设置参数
        OrderEvent orderEvent = new OrderEvent(123456);

        // 发布事件
        orderPublish.publishEvent(orderEvent);

        System.out.println("4、订单结束了");
    }
}