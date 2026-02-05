package com.example.lcj.designpattern.strategy;

/**
 * @Description: 上下文类，持有策略接口
 * @Auther: wuzhazha
 */
public class ReceiptStrategyContext {

    private IReceiptHandleStrategy receiptHandleStrategy;

    /**
     * 设置策略接口
     * 
     * @param receiptHandleStrategy
     */
    public void setReceiptHandleStrategy(IReceiptHandleStrategy receiptHandleStrategy) {
        this.receiptHandleStrategy = receiptHandleStrategy;
    }

    public void handleReceipt(Receipt receipt) {
        if (receiptHandleStrategy != null) {
            receiptHandleStrategy.handleReceipt(receipt);
        }
    }
}


