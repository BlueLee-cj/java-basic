package com.example.lcj.base.extend;

class Student extends Person {
    public Student() {
        System.out.println("Student");
    }

    @Override
    Integer getAge() {
        return 25;
    }

    public static void main(String[] args) {
        Person s = new Student();
        System.out.println(s.getAge());
    }
} 