package com.example.lcj.jvm.object;

public class ConstructorExample {
    public static void main(String... args) {
        Bar bar = new Bar();
        System.out.println(bar.getValue());             //-----------(3)
    }
}/* Output: 
            2
            0
            2
 *///:~