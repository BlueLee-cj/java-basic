package com.example.lcj.jdk8NewSyntax.java8.fourinterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class BiConsumerTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
