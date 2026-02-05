package com.example.lcj.base.generictype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/3 22:50
 */
public class GenericTest<T> {
    static <String, T, Person> String get(String string, Person person) {
        return string;
    }

    public static void main1(String[] args) {
        Integer first = 222;
        Long second = 333L;
        Integer result = get(first, second);
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<Integer>();
        System.out.println(list1.getClass() == list2.getClass());
        System.out.println(Arrays.asList(list1.getClass().getTypeParameters()));

    }
}
