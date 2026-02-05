package com.example.lcj.jvm.object;

public class InstanceInitializer01 {
    private int j = getI();
    private int i = 1;

    public InstanceInitializer01() {
        i = 2;
    }

    private int getI() {
        return i;
    }

    public static void main(String[] args) {
        InstanceInitializer01 ii = new InstanceInitializer01();
        System.out.println(ii.j);
    }
}  