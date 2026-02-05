package com.example.lcj.collections.failfast;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/12/3 22:34
 */
public class CopyOnWriterArrayListTest {
    public static void main(String[] args) {
        // method01();
        method02();
    }

    /**
     * 打印结果为：9 5 2 7
     *
     * 没有抛出 ConcurrentModificationException , 但是新插入的4个10，也没有打印出来。
     */
    public static void method01() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(9);
        list.add(5);
        list.add(2);
        list.add(7);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            list.add(10);
            System.out.println(iter.next());
        }
    }

    public static void method02() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(9);
        list.add(5);
        list.add(2);
        list.add(7);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            list.add(10);
            iter.next();
            // System.out.println(iter.next());
        }

        iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }


}
