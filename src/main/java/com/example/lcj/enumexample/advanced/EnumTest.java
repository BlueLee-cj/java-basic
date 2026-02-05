package com.example.lcj.enumexample.advanced;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class EnumTest {
    public DayEnum dayEnum;

    public EnumTest(DayEnum dayEnum) {
        this.dayEnum = dayEnum;
    }

    public void saysomething() {
        System.out.println(dayEnum.doSomething());
    }

    public static void main(String[] args) {
        EnumTest enumTest = new EnumTest(DayEnum.MON);
        enumTest.saysomething();
        DecimalFormat formater = new DecimalFormat("#0.00");
        formater.setRoundingMode(RoundingMode.DOWN);
        System.out.println(String.format("%s 公里", formater.format(.01122)));
    }
}
