package com.example.lcj.designpattern.chainOfResponsibilityPattern.demo1;

import org.springframework.stereotype.Component;

@Component
public class Wechat2Processor extends AbstractPaymentProcessor {

    @Override
    public void doHandler(Payment content) throws Exception {
        System.out.println("Processed wechat payment2.");
    }
}
