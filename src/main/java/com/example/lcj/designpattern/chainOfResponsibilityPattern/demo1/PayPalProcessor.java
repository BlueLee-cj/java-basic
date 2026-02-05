package com.example.lcj.designpattern.chainOfResponsibilityPattern.demo1;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void handle(Payment context) {
        System.out.println("Processed PayPal payment.");

    }
}
