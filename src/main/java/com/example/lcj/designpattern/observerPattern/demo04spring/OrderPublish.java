package com.example.lcj.designpattern.observerPattern.demo04spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

// 事件发布器。把事件发布到 spring容器中。

@Service
public class OrderPublish implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 获取spring容器，设置到私有属性。
        this.applicationContext = applicationContext;
    }

    // 调用spring容器 发布事件
    public void publishEvent(ApplicationEvent event){
        applicationContext.publishEvent(event);
    }
    
}