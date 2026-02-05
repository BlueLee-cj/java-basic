package com.example.lcj.collections.collection2map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("lc1", 1);
        Student s2 = new Student("lc2", 8);
        Student s3 = new Student("lc3", 2);
        Student s4 = new Student("lc4", 4);

        ArrayList<Student> list = new ArrayList<Student>();
        list.add(s4);
        list.add(s3);
        list.add(s2);
        list.add(s1);
        list.add(s1);
        list.add(null);
        list.add(null);

        for (Student stu : list) {
            System.out.println(stu);
        }

        System.out.println("----------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------------------------------");
//		Collections.sort(list);
//		for (Student stu : list) {
//			System.out.println(stu);
//		}
//		
        System.out.println("--------------------hashset---------------------");
        HashSet<Student> set = new HashSet<Student>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s4);
        set.add(null);
        set.add(null);
        for (Student student : set) {
            System.out.println(student);
        }
        System.out.println("--------------------treeset---------------------");
        TreeSet<Student> tree = new TreeSet<Student>();
        tree.add(s1);
        tree.add(s2);
        tree.add(s3);
        tree.add(s4);
        tree.add(s4);
        for (Student student : tree) {
            System.out.println(student);
        }
        System.out.println("--------------------hashmap---------------------");
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        map.put(1, s1);
        map.put(2, s2);
        map.put(3, s3);
        map.put(4, s4);
        map.put(null, null);

    }
}
