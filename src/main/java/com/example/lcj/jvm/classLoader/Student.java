package com.example.lcj.jvm.classLoader;

public class Student {
    public Student() {

    }

    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }


    public void show1(String s) {
        System.out.println("show1(): s = " + s);
    }

    protected void show2() {
        System.out.println("show2()");
    }

    void show3() {
        System.out.println("show3()");
    }

    private String show4(int age) {
        System.out.println("show4(): age = " + age);
        return "abcd";
    }
}
