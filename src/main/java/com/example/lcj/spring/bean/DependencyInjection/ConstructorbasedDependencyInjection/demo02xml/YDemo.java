package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo02xml;

import org.springframework.stereotype.Component;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/22 22:38
 */
@Component
public class YDemo implements I{
    @Override
    public void call() {
        System.out.println("call y");
    }
}
