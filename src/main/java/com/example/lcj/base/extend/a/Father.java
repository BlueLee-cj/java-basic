package com.example.lcj.base.extend.a;

import com.example.lcj.base.extend.b.Son;
import com.example.lcj.base.extend.b.SubSon;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/3 22:08
 */
public class Father {
    void method(){
        System.out.println("father");
    }

    public static void main(String[] args) {
        SubSon subSon = new SubSon();
        System.out.println(subSon instanceof Son);
        subSon.method2();
    }
}
