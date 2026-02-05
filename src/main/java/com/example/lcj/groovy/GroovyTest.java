package com.example.lcj.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.IOException;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/10 16:29
 */
public class GroovyTest {
    private static GroovyShell groovy = new GroovyShell();

    public static void main(String[] args) throws IOException {
        int i = 0;
        try {
            for (; i < 100000; i++) {
                String groovyInput = "1+1";
                groovy.evaluate(groovyInput).toString();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("exe over:" + i);

//        example();
//        example1();
    }

//    public static void example(){
//        Binding binding1 = new Binding();
//        binding1.setVariable("保额",1000);
//        binding1.setVariable("费率",0.01);
//        String formulaContent1="-保额*费率";
//        GroovyShell shell1 = new GroovyShell(binding1);
//        Object value1 = shell1.evaluate(formulaContent1);
//        System.out.println(value1);
//    }
}
