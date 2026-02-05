package com.example.lcj.base.refer;

import com.example.lcj.jvm.object.Student;

/**
 * @author lichengjian
 * @date 2022/9/18
 */
public class ReferTest {
    public static void main(String[] args) {
        Student student = new Student(11);
        Student student1 = student;
        student = null;
        System.out.println(student1);
        System.out.println(student);
    }
}
