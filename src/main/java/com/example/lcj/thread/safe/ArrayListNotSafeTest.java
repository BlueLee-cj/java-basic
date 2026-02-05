package com.example.lcj.thread.safe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lichengjian
 * @date 2024/5/19
 */
public class ArrayListNotSafeTest {
    public static void main(String[] args) {
        List<Integer> objects = new CopyOnWriteArrayList<>();
        List<Integer> objects1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
            objects1.add(i);
        }
        Iterator<Integer> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            iterator.remove();
            objects.remove(next);
        }
        System.out.println(objects);
    }
}
