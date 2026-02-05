package com.example.lcj.jdk8NewSyntax.simple;

public class B {
    public static void main(String[] args) {
        IMessage i = new MessageImpl();
        i.send("连接成功");
    }

}



