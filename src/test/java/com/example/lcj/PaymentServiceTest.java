package com.example.lcj;

import com.example.lcj.designpattern.chainOfResponsibilityPattern.demo1.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaBasicApplication.class)
public class PaymentServiceTest {
    @Autowired
    private PaymentHandleChainService paymentHandleChainService;

    @Autowired
    private CreditCard2Processor creditCard2Processor;

    @Autowired
    private PayPal2Processor payPal2Processor;

    @Autowired
    private Wechat2Processor wechat2Processor;

    @Test
    public void test() {
        paymentHandleChainService.execute(new Payment());
    }

    @Test
    public void test2() throws Exception {
        paymentHandleChainService.execute(new Payment());
        new AbstractPaymentProcessor.Builder()
                .addHandler(creditCard2Processor)
                .addHandler(payPal2Processor)
                .addHandler(wechat2Processor)
                .build().execute(new Payment());
    }
}
