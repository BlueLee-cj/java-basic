package com.example.lcj.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/6/13 16:55
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //int[] ints = new int[10];
        //int j = 9;
        //while (j > 0){
        //    ints[j] = j;
        //    j--;
        //}
        //System.out.println(ints.length);
        //
        //ArrayList<Integer> objects = new ArrayList<>(10);
        //System.out.println(objects.size());
        //int i = 11;
        //while (i > 0){
        //    objects.add(1);
        //    i--;
        //}
        //System.out.println(objects.size());
        //objects.set(5,1);


        //ArrayList<Integer> objects2 = new ArrayList<>();
        //objects2.add(1);
        //objects2.add(2);
        //objects2.add(1,3);
        //System.out.println(objects2.size());
        //objects2.remove(1);
        //
        //Vector<Object> objects1 = new Vector<>();
        //objects1.add(1);

        ArrayList<Integer> objects1 = new ArrayList<>();

        objects1.add(1);
        objects1.add(2);
        objects1.add(3);
        objects1.add(4);
        objects1.add(5);
        objects1.add(6);
        objects1.add(7);
        objects1.add(8);
        objects1.add(9);
        objects1.add(10);
        objects1.add(11);
        objects1.add(12);

        ArrayList<Integer> objects2 = new ArrayList<>();
        objects2.addAll(objects1);
        objects2.add(13);

        Arrays.sort(objects1.toArray());
    }
}
