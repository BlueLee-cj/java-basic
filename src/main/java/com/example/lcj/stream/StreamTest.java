package com.example.lcj.stream;

import java.util.*;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/22 13:59
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        List<String> collect = list.stream().map(userId -> Lists.newArrayList("sa" + userId, "sb" + userId))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(collect);
        double round = Math.round(2.40000001);
        System.out.println(round);

        ArrayList<String> objects = Lists.newArrayList();
        objects.add("xxx");
        objects.add(null);
        System.out.println(objects);

    }
}
