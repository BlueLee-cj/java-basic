package com.example.lcj.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author ：lcj
 * @description：TreeSet, LinkedHashSet and HashSet 的区别
 * @date ：Created in 2020/6/13 16:03
 */
public class TreeSetLinkedHashSetHashSet {
    public static void main(String args[]) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (String data : Arrays.asList("B", "E", "D", "C", "A")) {
            hashSet.add(data);
            linkedHashSet.add(data);
            treeSet.add(data);
        }

        //不保证有序
        System.out.println("Ordering in HashSet :" + hashSet);

        //FIFO保证安装插入顺序排序
        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);

        //内部实现排序
        System.out.println("Order of objects in TreeSet :" + treeSet);


    }

}
