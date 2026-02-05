package com.example.lcj.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ReceiptBuilder {

    public static List<Receipt> generateReceiptList() {
        // 直接模拟一堆回执对象
        List<Receipt> receiptList = new ArrayList<>();
        receiptList.add(new Receipt("我是MT2101回执喔", "MT2101"));
        // receiptList.add(new Receipt("我是MT1101回执喔", "MT1101"));
        receiptList.add(new Receipt("我是MT8104回执喔", "MT8104"));
        // receiptList.add(new Receipt("我是MT9999回执喔", "MT9999"));
        // ......
        return receiptList;
    }

    public static void main(String[] args) {
        List<Receipt> receiptList = ReceiptBuilder.generateReceiptList();
        // 循环处理
        for (Receipt receipt : receiptList) {
            if (StringUtils.equals("MT2101", receipt.getType())) {
                System.out.println("接收到MT2101回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (StringUtils.equals("MT1101", receipt.getType())) {
                System.out.println("接收到MT1101回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (StringUtils.equals("MT8104", receipt.getType())) {
                System.out.println("接收到MT8104回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (StringUtils.equals("MT9999", receipt.getType())) {
                System.out.println("接收到MT9999回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
                System.out.println("推送邮件");
            }
            // ......未来可能还有好多个else if
        }
    }

}


