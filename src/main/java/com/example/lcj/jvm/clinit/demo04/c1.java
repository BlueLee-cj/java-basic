package com.example.lcj.jvm.clinit.demo04;

class c1 {
    String name = "aaaaaa";

    //父类构造函数
    public c1() {
        print();
    }

    //该构造函数自始至终就没有被调用过
    public void print() {
        System.out.println(name);
    }
}