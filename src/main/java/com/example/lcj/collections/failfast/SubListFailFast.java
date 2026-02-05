package com.example.lcj.collections.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/9 19:20
 */
public class SubListFailFast {
    public static void main(String[] args) {
        List masterList = new ArrayList<>();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List branchList = masterList.subList(0, 3);

        //masterList.remove(0);
        //masterList.add("ten");
        //masterList.clear();

        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);

        for (Object o : branchList) {
            System.out.println(o);
        }
        System.out.println(masterList);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        for (String s : strings) {
            System.out.println(s);
            if ("three".equals(s)) {
                strings.remove(s);
            }
        }
        System.out.println(strings);

        Object o = new Object();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            synchronized (o){
                String next = iterator.next();
                if ("one".equals(next)) {
                    iterator.remove();
                }
             }
        }
        System.out.println(strings);

        CopyOnWriteArrayList<String> objects = new CopyOnWriteArrayList<>();
        objects.add("123");

    }
}
