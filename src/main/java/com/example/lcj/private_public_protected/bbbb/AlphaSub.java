package com.example.lcj.private_public_protected.bbbb;

import com.example.lcj.private_public_protected.aaaa.Alpha;

public class AlphaSub extends Alpha {
    public void test() {
        super.pub();
        super.pro();
        //Alpha的def方法为默认权限无法在外部包访问
        //super.def();
        //Alpha的pri方法为私有权限无法在外部包访问
        //super.pri();
    }
}
