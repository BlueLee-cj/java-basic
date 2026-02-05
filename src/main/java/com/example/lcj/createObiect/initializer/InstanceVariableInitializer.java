package com.example.lcj.createObiect.initializer;

public class InstanceVariableInitializer {

    private int i = 1;
    private int j = i + 1;

    public InstanceVariableInitializer(int var) {
        System.out.println(i);
        System.out.println(j);
        this.i = var;
        System.out.println(i);
        System.out.println(j);
    }

    {               // ʵ�������
        j += 3;

    }

    public static void main(String[] args) {
        new InstanceVariableInitializer(8);
    }
}
