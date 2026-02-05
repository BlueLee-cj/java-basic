package com.example.lcj.jdk8NewSyntax.simple;

public class A {
    public static void main(String[] args) {
        IMessage iMessage = msg -> System.out.println("发送信息："+msg);
        iMessage.send("连接成功");
    }
 
}
