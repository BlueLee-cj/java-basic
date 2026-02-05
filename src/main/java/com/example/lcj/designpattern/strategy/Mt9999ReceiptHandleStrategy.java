package com.example.lcj.designpattern.strategy;

public class Mt9999ReceiptHandleStrategy implements IReceiptHandleStrategy {

    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT9999:" + receipt.getMessage());
    }

}
