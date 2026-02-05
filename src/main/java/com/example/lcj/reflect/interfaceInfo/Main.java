package com.example.lcj.reflect.interfaceInfo;

public class Main {
    public static void main(String[] args) throws Exception {
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
        System.out.println("要特别注意：getInterfaces()只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型：");
        Class s1 = Integer.class.getSuperclass();
        Class[] is1 = s.getInterfaces();
        for (Class i : is1) {
            System.out.println(i);
        }
    }
}


