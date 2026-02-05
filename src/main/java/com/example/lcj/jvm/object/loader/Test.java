package com.example.lcj.jvm.object.loader;

public class Test{
    static int i=1;
    static{
        i=0;
        System.out.println(i);//Error：Cannot reference a field before it is defined（非法向前应用）
    }
    //static int i=1;

    public static void main(String args[]){
        System.out.println(i);
    }
}

