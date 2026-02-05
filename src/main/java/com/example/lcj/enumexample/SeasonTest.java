package com.example.lcj.enumexample;

import java.math.BigDecimal;

public class SeasonTest {
    public void judge(SeasonEnum s) {
        switch (s) {
            case SPRING:
                System.out.println("春天适合踏青。");
                break;
            case SUMMER:
                System.out.println("夏天要去游泳啦。");
                break;
            case FALL:
                System.out.println("秋天一定要去旅游哦。");
                break;
            case WINTER:
                System.out.println("冬天要是下雪就好啦。");
                break;
        }
    }

    public static void main(String[] args) {
            double newAverageStepFrequency = 123.666;
            BigDecimal bd = new BigDecimal(newAverageStepFrequency);
            System.out.println(bd.setScale(1, BigDecimal.ROUND_DOWN).doubleValue());
    }
}


