package com.example.lcj.designpattern.decorator.demo02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new
                    BufferedInputStream(new FileInputStream("D:/Test.txt")));
            while ((c = in.read()) >= 0) {
                //this is just for Test
                System.out.print((char) c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}