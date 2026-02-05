package com.example.lcj.reflect.method;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        // 获取Person的hello方法:
        Method h = Person.class.getMethod("hello");
        // 对Student实例调用hello方法:
        h.invoke(new Student());
//        实际上相当于：
//        Person p = new Student();
//        p.hello();
    }
}