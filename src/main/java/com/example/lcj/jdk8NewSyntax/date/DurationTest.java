package com.example.lcj.jdk8NewSyntax.date;

import java.time.*;

/**
 * @author lichengjian
 * @date 2021/2/12
 */
public class DurationTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
        LocalDate date2 = dt2.toLocalDate();
        LocalTime time2 = dt2.toLocalTime();

        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(time1, time2);
        // Duration d1 = Duration.between(dateTime1, dateTime2);
        // Duration d2 = Duration.between(instant1, instant2);

    }
}
