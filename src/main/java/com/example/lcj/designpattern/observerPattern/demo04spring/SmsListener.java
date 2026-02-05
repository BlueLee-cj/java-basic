package com.example.lcj.designpattern.observerPattern.demo04spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 监听器 ,有事件发布后，才会执行
@Component
public class SmsListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 获取事件中的参数。
        System.out.println("event.getSource的值是："+event.getSource());

        // 2---短信通知
        System.out.println("2、  监听器01、调用短信发送的接口 -> 恭喜喜提羽绒被子");
    }
}