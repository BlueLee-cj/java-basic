package com.example.lcj.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 策略工厂
 * @Auther: wuzhazha
 */
public class ReceiptHandleStrategyFactory {

    private static Map<String, IReceiptHandleStrategy> receiptHandleStrategyMap;

    static {
        ReceiptHandleStrategyFactory.receiptHandleStrategyMap = new HashMap<>();
        ReceiptHandleStrategyFactory.receiptHandleStrategyMap.put("MT2101", new Mt2101ReceiptHandleStrategy());
        ReceiptHandleStrategyFactory.receiptHandleStrategyMap.put("MT8104", new Mt8104ReceiptHandleStrategy());
    }

    public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType) {
        return receiptHandleStrategyMap.get(receiptType);

    }
}
