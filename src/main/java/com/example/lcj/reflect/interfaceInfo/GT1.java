package com.example.lcj.reflect.interfaceInfo;

import java.lang.reflect.ParameterizedType;

public class GT1 extends GT2<Integer> {
    public static void main(String[] args) {
        System.out.println(((ParameterizedType) new GT1().getClass().getGenericSuperclass()));
    }
}
