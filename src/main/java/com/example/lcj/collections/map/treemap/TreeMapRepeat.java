package com.example.lcj.collections.map.treemap;

import java.util.TreeMap;

public class TreeMapRepeat {
    public static void main(String[] args) {
        //TreeMap map = new TreeMap();
        //map.put(new Key(), "value one");
        //map.put(new Key(), "value two");
        //map.put(new Key(), "value three");
        //System.out.println(map.size());

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(55, "fifty-five");
        treeMap.put(56, "fifty-six");
        treeMap.put(57, "fifty-seven");
        treeMap.put(58, "fifty-eithty");
        treeMap.put(83, "eithty-five");
        treeMap.remove(57);
        treeMap.put(59, "fifty-nine");

    }
}