package com.example.lcj.jdk8NewSyntax.simple;

class MessageImpl implements IMessage{  //接口实现
    @Override
    public void send(String msg) {
        System.out.println("发送信息："+msg);
    }
}
