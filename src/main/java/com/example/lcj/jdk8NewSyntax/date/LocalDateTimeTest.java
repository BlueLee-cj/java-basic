package com.example.lcj.jdk8NewSyntax.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @author lichengjian
 * @date 2021/2/12
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(now);
        System.out.println(dt1);

    }
}
