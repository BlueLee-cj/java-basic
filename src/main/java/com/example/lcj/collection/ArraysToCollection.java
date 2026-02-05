package com.example.lcj.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author lichengjian
 * @date 2021/10/4
 */
public class ArraysToCollection {
    public static void main(String[] args) {
        String[] strs = {"222", "ishdi"};
        List<String> strings = Arrays.asList(strs);
        strings.add("wewe");
    }
}
