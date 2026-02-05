package com.example.lcj.collections;

import java.util.TreeSet;

/**
 * Exception in thread "main" java.lang.ClassCastException: com.example.lcj.collections.Student cannot be cast to java.lang.Comparable
 * 	at java.util.TreeMap.compare(TreeMap.java:1294)
 * 	at java.util.TreeMap.put(TreeMap.java:538)
 * 	at java.util.TreeSet.add(TreeSet.java:255)
 * 	at com.example.lcj.collections.TreeSetDemo.testPre(TreeSetDemo.java:44)
 * 	at com.example.lcj.collections.TreeSetDemo.main(TreeSetDemo.java:7)
 * 	原因分析：
 * 由于不知道该安照那一中排序方式排序，所以会报错。
 * 解决方法：
 * 1.自然排序
 * 2.比较器排序
 *
 * (1)自然排序要进行一下操作：
 * 1.Student类中实现 Comparable接口
 * 2.重写Comparable接口中的Compareto方法
 *
 * (2).比较器排序
 * 比较器排序步骤：
 * 1.单独创建一个比较类，这里以MyComparator为例，并且要让其继承Comparator接口
 * 2.重写Comparator接口中的Compare方法
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        //testPre();
        testPre1();
    }

    public static void testInt() {
        // 创建集合对象
        // 自然顺序进行排序
        TreeSet<Integer> ts = new TreeSet<Integer>();

        // 创建元素并添加
        // 20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        // 遍历
        for (Integer i : ts) {
            System.out.println(i);
        }
    }

    public static void testPre() {
        TreeSet<Student> ts=new TreeSet<Student>();
        //创建元素对象
        Student s1=new Student("zhangsan",20);
        Student s2=new Student("lis",22);
        Student s3=new Student("wangwu",24);
        Student s4=new Student("chenliu",26);
        Student s5=new Student("zhangsan",22);
        Student s6=new Student("qianqi",24);

        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        //遍历
        for(Student s:ts){
            System.out.println(s.getName()+"-----------"+s.getAge());
        }
    }
    public static void testPre1() {
        //创建集合对象
        //TreeSet(Comparator<? super E> comparator) 构造一个新的空 TreeSet，它根据指定比较器进行排序。
        TreeSet<Student> ts=new TreeSet<Student>(new MyComparator());

        //创建元素对象
        Student s1=new Student("zhangsan",20);
        Student s2=new Student("lis",22);
        Student s3=new Student("wangwu",24);
        Student s4=new Student("chenliu",26);
        Student s5=new Student("zhangsan",22);
        Student s6=new Student("qianqi",24);

        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        //遍历
        for(Student s:ts){
            System.out.println(s.getName()+"-----------"+s.getAge());
        }
    }
}

