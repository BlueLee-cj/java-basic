package com.example.lcj.base.classobject.demo1;

import java.util.Arrays;

/**
 * @author lichengjian
 * @date 2024/1/7
 */
public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println(cc.getName());
        System.out.println(cc.isInterface());
        System.out.println(cc.getSimpleName());
        System.out.println(cc.getCanonicalName());
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("com.example.lcj.base.classobject.demo1.FancyToy");
        printInfo(c);
        Arrays.stream(c.getInterfaces()).forEach(ToyTest::printInfo);
        Object o = c.getSuperclass().newInstance();
        printInfo(o.getClass());
    }
}
