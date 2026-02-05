package com.example.lcj.designpattern.observerPattern.demo04spring;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件
 */

public class OrderEvent extends ApplicationEvent {
    public OrderEvent(Object source) {
        super(source);
    }
}