package com.example.lcj.base;

class Person {
    private int age;
    public Person() {
        System.out.println("Person B");
    }

    public void Person() {
        System.out.println("Person A");
    }

    int getAge() {
        return 20;
    }

    public void printAge() {
        System.out.println(getAge());
        this.getAge();
        age = 12;
        this.age = 1;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.printAge();
    }
}