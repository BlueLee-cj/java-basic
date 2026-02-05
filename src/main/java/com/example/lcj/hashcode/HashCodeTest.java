package com.example.lcj.hashcode;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/16 21:07
 */
public class HashCodeTest {
    public static void main(String[] args) {
        new Object();
        java.lang.String a = "aaaa";
        Integer b = 11;
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);

        LinkedList<Object> objects1 = new LinkedList<>();
        objects1.add(1);
        System.out.println(objects.equals(objects1));

        Objects.isNull("123");
    }
}
