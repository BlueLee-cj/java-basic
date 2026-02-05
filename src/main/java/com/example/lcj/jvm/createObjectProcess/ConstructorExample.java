package com.example.lcj.jvm.createObjectProcess;

public class ConstructorExample {
    private int i;  

    ConstructorExample() {
        this(1);
    }

    ConstructorExample(int i) {  
        this.i = i;
        System.out.print(this.i);
    }

    public static void main(String[] args) {
        new ConstructorExample();
    }
}  