package com.example.lcj.base.calendar;

import java.util.Calendar;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/10/21 11:21
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.YEAR);
        instance.add(1,1);
    }
}
