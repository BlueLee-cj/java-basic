package com.example.lcj.base.paramquote;



/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/8 9:21
 */
public class Person {
    private String name;
    private int age;
    private Animal animal;

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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", animal=" + animal +
                '}';
    }
}
