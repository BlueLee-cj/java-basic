package com.example.lcj.collections;

import java.util.LinkedList;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/10/26 19:27
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(1,"123");
        objects.remove();
        objects.remove(1);
        objects.get(0);
    }
}
