package com.example.lcj.jdk8NewSyntax.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;

class TestRun {
    public static void main(String[] args) {
        List<Test> TestList = new ArrayList<>();
        Date d = new Date();
        for (int i = 1; i <= 3; i++) {
            Test t = new Test(i, DateUtils.addDays(d, i), DateUtils.addMonths(d, i));
            TestList.add(t);
        }
        for (int i = 1; i <= 3; i++) {
            // Test t = new Test(i, DateUtils.addMonths(d, i));
            Test t = new Test(i);
            t.setTime(DateUtils.addDays(d, i + 1));
            TestList.add(t);

            Test t1 = new Test(i);
            TestList.add(t1);

            Test t2 = new Test(i, DateUtils.addDays(d, i), DateUtils.addDays(d, i));
            TestList.add(t2);

            Test t3 = new Test(i, DateUtils.addDays(d, i));
            TestList.add(t3);
        }

        TestList.forEach(o -> {
            System.out.println(o.toString());
        });
        // List<Test> sort = TestList.stream()
        // .sorted(Comparator.comparing(Test::getState)
        // .thenComparing(Test::getTime, Comparator.reverseOrder()))
        // .collect(Collectors.toList());

        // List<Test> sort = TestList.stream()
        // .sorted(Comparator.comparing(Test::getState, Comparator.reverseOrder())
        // .thenComparing(Test::getTime, Comparator.nullsLast(Date::compareTo)))
        // .collect(Collectors.toList());

        // List<Test> sort = TestList.stream()
        // .sorted(Comparator.comparing(Test::getState)
        // .thenComparing(Test::getTime, Comparator.nullsFirst(Date::compareTo)).reversed())
        // .collect(Collectors.toList());

        List<Test> sort = TestList.stream()
                .sorted(Comparator.comparing(Test::getState)
                        .thenComparing(Test::getTime, Comparator.nullsFirst(Date::compareTo))
                        .thenComparing(Test::getTime2, Comparator.nullsFirst(Date::compareTo)).reversed())
                .collect(Collectors.toList());

        System.out.println("------------------------------------");
        sort.forEach(o -> {
            System.out.println(o.toString());
        });

        System.out.println("-----------------原来-------------------");
        TestList.forEach(o -> {
            System.out.println(o.toString());
        });



    }
}
