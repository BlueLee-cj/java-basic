package com.example.lcj.hashcode.hashcodeequals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/9 18:50
 */
public class MainTest {
    public static void main(String[] args) {
        Set<EqualsObject> hashSet = new HashSet<>();
        EqualsObject a = new EqualsObject(1, "noe");
        EqualsObject b = new EqualsObject(1, "noe");
        EqualsObject c = new EqualsObject(1, "noe");

        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);
        System.out.println(hashSet.size());
        System.out.println("1111".hashCode());
        System.out.println("1111".hashCode());
        System.out.println("1111".hashCode());
        System.out.println( new String("1111").hashCode());
        System.out.println( new String("1111").hashCode());
        System.out.println( new String("1111").hashCode());


        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);

        LinkedList<Object> objects1 = new LinkedList<>();
        objects1.add(1);
        objects1.add(2);
        System.out.println(objects.equals(objects1));
    }
}
