package com.example.lcj.jdk8NewSyntax.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author lichengjian
 * @date 2021/2/12
 */
public class LocalDateTest {
    public static void main1(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate startDate = date.withDayOfMonth(1);
        LocalDate endDate = date.plusMonths(1).withDayOfMonth(1);
        System.out.println(date + " || " + startDate + " || " + endDate);
        System.out.println("year:" + date.getYear() + " month:" + date.getMonth() + " day:" + date.getDayOfMonth());
        System.out.println("dayOfweek:" + date.getDayOfWeek() + " lenthOfMonth:" + date.lengthOfMonth());

        ChronoField.values();
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
        LocalDate datett = LocalDate.parse("2014-03-18");
        System.out.println(datett);

        // LocalDate date1 = LocalDate.of(2014, 3, 18);
        // LocalDate date2 = date1.withYear(2011);
        // LocalDate date3 = date2.withDayOfMonth(25);
        // LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.plusWeeks(1);
        LocalDate date3 = date2.minusYears(3);
        LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(now);

        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime());

    }
}
