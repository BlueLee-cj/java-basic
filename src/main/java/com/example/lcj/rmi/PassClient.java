package com.example.lcj.rmi;

import java.rmi.Naming;

public class PassClient {
    public static void main(String[] args) {
        try {
            PassIn in = (PassIn) Naming.lookup("rmi://localhost:1413/Hello");
            String get = in.pass("JACK");
            System.out.println(get);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
