package com.example.lcj.base.generictype;

public class Test1 {

    public static void main(String[] args) {

        // begin Test CC
        CC<Integer> cc = new CC<Integer>(1);
        cc.print();
        int icc = cc.getOb();
        System.out.println("icc=" + icc);

        CC<String> cc2 = new CC<String>("eeee");
        cc2.print();
        String icc2 = cc2.getOb();
        System.out.println("icc2=" + icc2);
        // end Test CC
    }
}
