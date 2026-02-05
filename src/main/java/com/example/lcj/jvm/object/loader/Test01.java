package com.example.lcj.jvm.object.loader;

public class Test01{
    int j=1;
    static{
        i=0;
        //System.out.println(i);
    }

    static int i=1;

    public static void main(String args[]){
        System.out.println(i);
    }
}/* Output: 
        1
 *///:~