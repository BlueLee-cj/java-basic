package com.example.lcj.createObiect.clone;

import java.lang.reflect.Constructor;

public class Student implements Cloneable {
    private int id;

    public Student(Integer id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    public static void main(String[] args) throws Exception {

        Constructor constructor = Student.class.getConstructor(Integer.class);
        Student stu3 = (Student) constructor.newInstance(123);
        Student stu4 = (Student) stu3.clone();
        System.out.println(stu4.id);
    }
}
