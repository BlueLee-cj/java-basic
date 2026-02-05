package com.example.lcj.swap;

import com.example.lcj.collections.Student;

public class Swap5 {
    public static void main(String[] args) {

        int[] i = {3, 5};

        swap(i);
        System.out.println(i[0]);
        System.out.println(i[1]);


        //  String x = "x111";
        //  String y = "y111";
        String x = "x111";
        String y = "y111";
        swap(x, y);
        System.out.println(x);
        System.out.println(y);

        Student target1 = new Student("张伟", 23);
        Student target2 = new Student("吴天", 24);
        swapII(target1, target2);
        System.out.println(target1 + ":" + target2);//输出后，仍然target1的name和age还是张伟23；target2的name和age还是吴天24
    }

    public static void swap(String a, String b) {
        String temp = a;
        a = b;
        b = temp;
    }

    public static void swap(Student s1, Student s2) {
        Student s3 = new Student();
        s3 = s1;
        s1 = s2;
        s2 = s3;
    }

    public static void swapII(Student s1,Student s2){
        Student s3 = new Student();
        s3 = s1;
        int age = s3.getAge();
        s1.setAge(s2.getAge());
        s2.setAge(age);
    }


    public static void swap(int[] a)
    {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }

}

//运行结果：java Swap5
//x111
//y111