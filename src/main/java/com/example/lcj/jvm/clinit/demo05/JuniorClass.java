package com.example.lcj.jvm.clinit.demo05;

public class JuniorClass extends SeniorClass {
    private String name;

    public JuniorClass() {
        super();                //调用父类的构造方法
        System.out.println("子类构造方法");
        name = "Junoir";
    }

    public String toString()   //覆写父类的toString()

    {

        System.out.println(name);

        return name.toUpperCase();
    }

}