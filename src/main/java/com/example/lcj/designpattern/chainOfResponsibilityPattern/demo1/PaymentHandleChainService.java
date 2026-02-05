package com.example.lcj.designpattern.chainOfResponsibilityPattern.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentHandleChainService {

    @Autowired
    private List<PaymentProcessor> paymentProcessors;

    public void execute(Payment payment) {
        for (PaymentProcessor paymentProcessor : paymentProcessors) {
            paymentProcessor.handle(payment);
        }
    }
}
