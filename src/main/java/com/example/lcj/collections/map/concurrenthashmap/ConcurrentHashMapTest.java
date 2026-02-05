package com.example.lcj.collections.map.concurrenthashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

import com.example.lcj.collections.Student;
import com.example.lcj.collections.map.hashmap.UserKey;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/12 13:33
 */
public class ConcurrentHashMapTest {
    private static ConcurrentHashMap map = new ConcurrentHashMap();

    public static void main(String[] args) {
        for (int i = 0; i < 13; i++) {
            map.put(new UserKey(), new Student());
        }
        map.get(new UserKey());
        Collections.synchronizedMap(new HashMap<Object, Object>());
        new Hashtable<>();
    }
}
