package com.example.lcj.jdk8NewSyntax.Stream.map;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/**
 * @author lichengjian
 * @date 2021/2/10
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);
        List<int[]> pairs = num1.stream().flatMap(i -> num2.stream().map(j -> new int[] {i, j})).collect(toList());
        print(pairs);
    }

    private static void print(List<int[]> list) {
        list.forEach(item -> System.out.println("{" + item[0] + "," + item[1] + "}"));
    }
}
