package com.example.lcj.private_public_protected.aaaa;

public class Beta {
    public void test() {
        com.example.lcj.private_public_protected.aaaa.Alpha alpha = new com.example.lcj.private_public_protected.aaaa.Alpha();
        alpha.pub();
        alpha.pro();
        alpha.def();
        //可以看到编译Beta，java时报错，提示Alpha类中的pro方法是私有的，不可访问
        //alpha.pri();
    }

}
