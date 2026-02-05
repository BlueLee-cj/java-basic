package com.example.lcj.serializable;

import java.io.Serializable;

public class Person implements Serializable {

    /**
     * 序列化ID
     * s​e​r​i​a​l​V​e​r​s​i​o​n​U​I​D​:​ ​字​面​意​思​上​是​序​列​化​的​版​本​号​，
     * 凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量
     */
//	private static final long serialVersionUID = -2748347789044859968L;
    private int age;
    private String name;
    private String sex;
    private String highth;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
