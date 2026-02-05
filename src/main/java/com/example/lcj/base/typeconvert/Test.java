package com.example.lcj.base.typeconvert;

/**
 * @author lichengjian
 * @date 2021/10/23
 */
public class Test {
    public static void main(String[] args) {

        Father father1 = new Son();
        Son son1 = (Son) father1;

        Father father = new Father();
        Son son = (Son) father;
    }

}
