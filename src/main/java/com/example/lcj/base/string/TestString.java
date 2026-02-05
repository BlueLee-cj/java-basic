package com.example.lcj.base.string;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.google.common.collect.Lists;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/6/28 20:04
 */
public class TestString {
    public static void main(String[] args) {

        ArrayList<Integer> integers = Lists.newArrayList(11, 22, 33);
        System.out.println(integers.subList(0, 3));
        System.out.println(integers.stream().limit(3).collect(Collectors.toList()));

        System.out.println(LongStream.rangeClosed(3, 4).boxed().collect(Collectors.toList()));
    }

    public static double runningMeterToKilometre(long distance) {
        return floor((double) distance / 1000.0D, 2);
    }

    private static double floor(double num, int scale) {
        BigDecimal bd = new BigDecimal(Double.toString(num));
        return bd.setScale(scale, 1).doubleValue();
    }
}
