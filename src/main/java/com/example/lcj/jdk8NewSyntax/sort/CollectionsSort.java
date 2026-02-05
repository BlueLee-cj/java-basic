package com.example.lcj.jdk8NewSyntax.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lichengjian
 * @date 2021/10/4
 */
public class CollectionsSort {
    public static void main(String[] args) {

        // 写法一：使用匿名内部类
        // 好好学习，天天向上
        List<String> words = Arrays.asList("good", "good", "study", "day", "day", "up");

        // public static <T> void sort(List<T> list, Comparator<? super T> c)
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 降续排序
                return s2.compareTo(s1);
            }
        });

        System.out.println(words);


        // 写法二：使用Lambda表达式
        // 咱俩谁跟谁
        words = Arrays.asList("we", "two", "who", "and", "who");
        Collections.sort(words, (String s1, String s2) -> {
            return s2.compareTo(s1);
        });
        System.out.println(words);


        // 写法三：使用Lambda表达式(简写)
        // 有事起奏,无事退朝
        words = Arrays.asList("if", "you", "have", "something", "to", "say", "then", "say!",
                "if", "you", "have", "nothing", "to", "say", "go", "home!");
        Collections.sort(words, (s1, s2) -> s2.compareTo(s1));
        System.out.println(words);
    }
}
