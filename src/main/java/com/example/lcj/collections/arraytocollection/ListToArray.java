package com.example.lcj.collections.arraytocollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/8 21:17
 */
public class ListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Object[] objects = list.toArray();

        String[] strings = new String[2];
        list.toArray(strings);
        System.out.println(Arrays.asList(strings));

        String[] array3 = new String[3];
        list.toArray(array3);
        System.out.println(Arrays.asList(array3));

        List<String> list1 = new ArrayList<>(2);
        list1.add("guan");
        list1.add("bao");
        String[] string1 = new String[1];
        list1.toArray(string1);
        System.out.println(Arrays.asList(string1));
    }
}
