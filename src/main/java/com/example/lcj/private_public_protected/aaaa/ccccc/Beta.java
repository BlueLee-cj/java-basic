 package com.example.lcj.private_public_protected.aaaa.ccccc;

import com.example.lcj.private_public_protected.aaaa.Alpha;

public class Beta {
    public void test() {
        Alpha alpha = new Alpha();
        alpha.pub();
        //alpha.pro();
        //alpha.def();
        //可以看到编译Beta，java时报错，提示Alpha类中的pro方法是私有的，不可访问
        //alpha.pri();
    }

}
