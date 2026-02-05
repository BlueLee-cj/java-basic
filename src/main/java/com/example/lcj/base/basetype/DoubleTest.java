package com.example.lcj.base.basetype;

import java.math.BigDecimal;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/2/6 14:52
 */
public class DoubleTest {
    public static void main(String[] args) {

        double a = 6.6;
        double b = 0.0;
        System.out.println(a / b);

        int c = 6;
        int d = 0;
        // System.out.println(c / d);

        BigDecimal e = BigDecimal.valueOf(6);
        BigDecimal f = BigDecimal.ZERO;
        System.out.println(e.divide(f));

    }
}
