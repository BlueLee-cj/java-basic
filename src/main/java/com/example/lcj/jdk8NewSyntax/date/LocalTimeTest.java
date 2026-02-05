package com.example.lcj.jdk8NewSyntax.date;

/**
 * @author lichengjian
 * @date 2021/2/12
 */
public class LocalTimeTest {
    public static void main(String[] args) {
        for (int i = 0; i < 24; i++) {
            System.out.println(i + ":" +getTimePeriod(i));
        }
    }

    private static int getTimePeriod(int hour) {
        int periodHour = hour - 6 + 1;
        int period = periodHour / 8;

        if (periodHour % 8 > 0) {
            period++;
        }

        return period;
    }
}
