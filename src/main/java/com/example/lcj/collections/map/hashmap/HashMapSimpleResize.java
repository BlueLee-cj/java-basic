package com.example.lcj.collections.map.hashmap;

import com.example.lcj.collections.Student;

import java.util.HashMap;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/10 21:42
 */
public class HashMapSimpleResize {
    private static HashMap map = new HashMap();

    public static void main(String[] args) {
        for (int i = 0; i < 13; i++) {
            map.put(new UserKey(), new Student());
        }
    }
}
