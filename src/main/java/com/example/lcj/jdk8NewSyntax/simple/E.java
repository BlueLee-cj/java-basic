package com.example.lcj.jdk8NewSyntax.simple;

public class E {
    public static void main(String[] args) {
        IMessage i = msg -> System.out.println("发送信息："+msg);   //lambda表达式
        i.send("连接成功");
    }
}
