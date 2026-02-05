package com.example.lcj.createObiect.reflect;

import java.lang.reflect.Constructor;

public class Student {

    private int id;

    public Student(Integer id) {
        this.id = id;
    }

    public static void main(String[] args) throws Exception {

        Constructor<Student> constructor = Student.class.getConstructor(Integer.class);
        Student stu3 = constructor.newInstance(123);
        System.out.println(stu3.id);
    }
}
