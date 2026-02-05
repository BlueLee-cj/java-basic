package com.example.lcj.base;

public class Child extends Parent {
    public Child(String a, String b) {
        super(a, b);
    }

    public static void main(String arg[]) {
        Parent p = new Parent("south", "north");
        Parent t = new Child("east", "west");
        p.print();
        t.print();
    }

    public void print() {
        System.out.println(one + " to " + two);
    }
}