package com.example.lcj.base;

class Man {
    //    private final int i = 0;
    private final int i = 0;

    public Man() {
//        i = 1;//错误
//        final Object obj = new Object();
        final Object obj;
//        obj = new Object();//错误
    }

    public static void main(String[] args) {
        final Object obj;
        obj = new Object();
        System.out.println(obj);
    }
}