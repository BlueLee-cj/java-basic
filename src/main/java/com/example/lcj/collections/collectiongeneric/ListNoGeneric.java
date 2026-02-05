package com.example.lcj.collections.collectiongeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/8 21:38
 */
public class ListNoGeneric {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(111));
        a1.add(new String("hello a1a1"));

        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add(new String("hello a2a2"));


        List<Integer> a3 = a1;
        //a3.add(new Object());
        a3.add(new Integer(3333));
        //a3.add(new String("hello a2a2"));

        List<?> a4 = a1;
        a1.remove(0);
        a4.clear();
        //a4.add(new Object());
        //a4.add(new Integer(333lo'ca3));
        //a4.add(new String("hello a2a2"));

        List<Integer> intlist = new ArrayList<>(3);
        intlist.add(111);
        //List<Object> objectList = intlist;

        List intlist1 = new ArrayList<>(3);
        intlist.add(111);
        List<Object> objectList = intlist1;


        List<Object> a5 = new ArrayList<Object>(3);
        a5.remove(0);
        a5.clear();
        a5.add(new Object());
        a5.add(new Integer(3333));
        a5.add(new String("hello a2a2"));
    }
}
