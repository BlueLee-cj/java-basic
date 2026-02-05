package com.example.lcj.collections.collection2map;

public class Student implements Comparable {
    private String name;
    private int age;

    public Student(String name, int age) {
        super();
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

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name + ":" + age;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        int z = this.age - ((Student) o).age;
        if (z > 0) {
            return 1;
        } else if (z < 0) {
            return -1;
        } else {
            return 0;
        }

    }

}
