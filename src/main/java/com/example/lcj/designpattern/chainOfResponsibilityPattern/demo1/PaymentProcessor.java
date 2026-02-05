package com.example.lcj.designpattern.chainOfResponsibilityPattern.demo1;

public interface PaymentProcessor {
    /**
     * 节点处理
     *
     * @param context
     */
    void handle(Payment context);

}
