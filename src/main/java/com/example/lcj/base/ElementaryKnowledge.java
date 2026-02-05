package com.example.lcj.base;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ：lcj
 * @description：Java基础支持
 * @modified By：
 * @date ：Created in 2019/6/26 17:16
 */
public class ElementaryKnowledge {
    public static void main(String[] args) {
        System.out.println("5" + 2);
        int total = 0;
        for (int i = 0; i < 4; i++) {
            if (i == 1) continue;
            if (i == 2) break;
            total += i;
        }
        System.out.println(total);
        String s = null;
//        if( (s!=null) & (s.length()>0) ){}
//        if( (s!=null) && (s.length()>0) ){}
//        if( (s==null) | (s.length()==0) ){}
//        if( (s==null) || (s.length()==0) ){}
        try {
            // do something that may cause an Exception
            throw new IOException("11");
        } catch (FileNotFoundException ex) {
            System.out.print("FileNotFoundException!");
        } catch (IOException ex) {
            System.out.print("IOException!");
        } catch (Exception ex) {
            System.out.print("Exception!");
        }

        int count = 0;
        for (int i = 1; i <= 11; i *= 2) for (int j = 1; j <= i; j++) count++;
        System.out.println("count=" + count);

        //1 2 4 8
        //1 2 4 8

        int c;
        c = 2;
        System.out.println(c);
        System.out.println(c++);
        System.out.println(c);

        int[] x = new int[10];
        System.out.println(x[0]);
    }
}
