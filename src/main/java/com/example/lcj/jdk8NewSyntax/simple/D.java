package com.example.lcj.jdk8NewSyntax.simple;

public class D {
    public static void main(String[] args) {
        IMessage i = (msg) -> {                      //lambda表达式
            System.out.println("发送信息：" + msg);
        };
        i.send("连接成功");
    }
}


