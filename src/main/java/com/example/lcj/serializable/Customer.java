package com.example.lcj.serializable;

import java.io.Serializable;

class Customer implements Serializable {
    //Customer����û�ж���serialVersionUID
    private String name;
    private int age;

    //����ӵ�sex����
    private String sex;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /*
     * @MethodName toString
     * @Description ��дObject���toString()����
     * @author xudp
     * @return string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}