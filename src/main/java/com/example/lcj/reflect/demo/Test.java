package com.example.lcj.reflect.demo;

public class Test {

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("com.example.lcj.reflect.demo.Student");
            System.out.println(c.getName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Class<?>[] ifs = c.getInterfaces();
        for (Class<?> i : ifs) {
            System.out.println(i);
        }

        Class<?> s = c.getSuperclass();
        System.out.println(s);
    }
}