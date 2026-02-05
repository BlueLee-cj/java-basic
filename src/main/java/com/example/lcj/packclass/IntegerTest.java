package com.example.lcj.packclass;

public class IntegerTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Integer.valueOf(1) == 1);
        System.out.println(Integer.valueOf(1) == (new Integer(1)));
        System.out.println(Integer.valueOf(128) == Integer.valueOf(128));
    }

}
