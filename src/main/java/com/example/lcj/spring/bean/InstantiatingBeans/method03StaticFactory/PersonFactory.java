package com.example.lcj.spring.bean.InstantiatingBeans.method03StaticFactory;

public class PersonFactory {
    public static Person getPerson(String arg) {
        if (arg.equalsIgnoreCase("chinese")) {
            return new Chinese();
        } else {
            return new American();
        }
    }
}
