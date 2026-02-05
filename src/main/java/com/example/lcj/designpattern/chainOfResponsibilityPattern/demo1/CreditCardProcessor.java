package com.example.lcj.designpattern.chainOfResponsibilityPattern.demo1;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void handle(Payment context) {
        System.out.println("Processed credit card payment.");
    }
}
