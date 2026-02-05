package com.example.lcj.jvm.Process;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/19 13:39
 */
public class Person {
    private String name;
    private int  age ;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
