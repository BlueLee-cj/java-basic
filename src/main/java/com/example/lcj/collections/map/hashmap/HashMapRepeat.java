package com.example.lcj.collections.map.hashmap;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapRepeat {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        HashMap map1 = new HashMap(16);
        map1.put(new Key(), "value one");
        map.put(new Key(), "value two");
        System.out.println(map.size());
    }
}