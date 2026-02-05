package com.example.lcj.base.unpackpack;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/3/26 18:18
 */
public class PackType {

    public static void main(String[] args) {
        //Long a = null;
        //long b = a;
        //Long a = null;
        //increment(a);
        //
        //Long n1 = null;
        //long n2 = 1L;
        //if(n1 == n2){
        //}


        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);


        double i11 = 100.0;
        double i21 = 100.0;
        double i31 = 200.0d;
        double i41 = 200.0;
        System.out.println(i11==i21);
        System.out.println(i31==i41);

        double a = 100.0;
        double b = 100.0;
        System.out.println(a==b);
    }

    public static long increment(long n) {
        return n++;
    }
}
