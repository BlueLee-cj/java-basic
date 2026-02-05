package com.example.lcj.jvm.processinitialization;

public class Test1{
    static{
        i=0;
        //System.out.println(i);
    }

    static int i=1;

    public static void main(String args[]){
        System.out.println(i);
    }
}
/* Output:
        1
 *///:~