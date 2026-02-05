package com.example.lcj.createObiect.initializer;

public class ConstrutorExample {
    private int i;

    ConstrutorExample() {
        //super();
        this(1);
    }

    ConstrutorExample(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        ConstrutorExample construtorExample = new ConstrutorExample();
        System.out.println(construtorExample.i);
    }
} 