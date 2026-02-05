package com.example.lcj.jvm.object.size;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author rickiyang
 * @date 2020-12-27
 * @Desc TODO
 */
public class ObjSiZeTest {

    public static void main(String[] args) {
        ClassLayout classLayout = ClassLayout.parseInstance(new ObjA());
        System.out.println(classLayout.toPrintable());
    }
}



class ObjA {}
