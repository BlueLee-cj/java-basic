package com.example.lcj.jdk8NewSyntax.simple;

public class C {
    public static void main(String[] args) {
        IMessage i = new IMessage() {        //匿名内部类
            @Override
            public void send(String msg) {
                System.out.println("发送信息：" + msg);
            }
        };
        i.send("连接成功");
    }

}

