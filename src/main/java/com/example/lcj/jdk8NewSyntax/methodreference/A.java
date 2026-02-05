package com.example.lcj.jdk8NewSyntax.methodreference;

public class A {
    public static void main(String[] args) {
        IMessage i = new Person()::print; // 引用普通方法
        i.send("普通方法");
        IMessage i2 = Person::print2; // 引用静态方法
        i2.send("静态方法");
        ICreat<Person> iCreat = Person::new; // 引用构造方法，一般是返回的是类的实例
        Person person = iCreat.creat();
    }
}
