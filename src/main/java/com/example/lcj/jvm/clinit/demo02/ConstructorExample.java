package com.example.lcj.jvm.clinit.demo02;



public class ConstructorExample {
    /**
     * 父类的类构造器<clinit>() -> 子类的类构造器<clinit>()
     * -> 父类的成员变量和实例代码块 -> 父类的构造函数
     * -> 子类的成员变量和实例代码块 -> 子类的构造函数
     * @param args
     */
    public static void main(String... args) {
        Foo foo = new Foo();
        Bar bar = new Bar();
        System.out.println(bar.getValue());
    }
}