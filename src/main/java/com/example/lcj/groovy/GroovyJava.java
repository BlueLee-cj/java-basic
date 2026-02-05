package com.example.lcj.groovy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.util.JSONPObject;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilationFailedException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/16 23:12
 */
public class GroovyJava {

    void print(){
        System.out.println("没有参数!!!!");
    }

    //List<String> printArgs(String str1, String str2, String str3) {
    //    String jsonString = "[\"" + str1 + "\",\"" + str2 + "\",\"" + str3 + "\"]";
    //    return JSON.parseObject(jsonString, new TypeReference<List<String>>() {});
    //}

    public static Object evaluate1(){
        String type = "List<String>";
        String jsonString = "[\"wei.hu\",\"mengna.shi\",\"fastJson\"]";

        Binding binding = new Binding();
        binding.setProperty("jsonString", jsonString);
        binding.setProperty("type", type);
        GroovyShell groovyShell = new GroovyShell(binding);

        // todo 必须引用 import 否则会出错
        return groovyShell.evaluate(
                "import com.alibaba.fastjson.JSON;\n" +
                        "import com.alibaba.fastjson.TypeReference;\n" +
                        "TypeReference<"+ type +"> typeReference = new TypeReference<" + type +">(){};\n" +
                        "JSON.parseObject(jsonString, typeReference);"
        );
    }

    public static void evaluate3() throws CompilationFailedException, IOException {
        Binding binding = new Binding();
        //和参数名称一致
        binding.setProperty("arg", "chy");
        GroovyShell groovyShell = new GroovyShell(binding);
        Object result = groovyShell.evaluate(new File("src/main/java/com/chy/groovy/FunArgGroove.groovy"));
        System.out.println(result.toString());
    }

    public static void evaluate4() throws CompilationFailedException, IOException {
        Binding binding = new Binding();
        GroovyShell groovyShell = new GroovyShell(binding);
        Object result = groovyShell.evaluate(new File("src/main/java/com/chy/groovy/FunGroove.groovy"));
    }

    public static void evaluate5() throws CompilationFailedException, IOException {
        GroovyShell groovyShell = new GroovyShell();
        Script script= groovyShell.parse(new File("src/main/java/com/chy/groovy/ScriptGroove.groovy"));
        Object result = script.invokeMethod("print",null);
    }

    public static void evaluate6() throws CompilationFailedException, IOException {
        GroovyShell groovyShell = new GroovyShell();
        Script script= groovyShell.parse(new File("src/main/java/com/chy/groovy/ScriptGroove.groovy"));
        Object[] args = {"1","2","3"};
        Object result = script.invokeMethod("printArgs",args);
        if(null!=result) {
            List<String> ls = (List<String>)result;
            ls.stream().forEach(System.out::println);
        }
    }

    public static void main( String[] args ) {
        List<String> ls;
        ls = (List<String>) evaluate1();
        if(null!=ls) {
            ls.stream().forEach(System.out::println);
        }
        System.out.println("==================evaluate1-end=================");
        try {
            evaluate3();
            System.out.println("==============evaluate3-end=====================");
            evaluate4();
            System.out.println("==============evaluate4-end=====================");
            evaluate5();
            System.out.println("==============evaluate5-end=====================");
            evaluate6();
            System.out.println("==============evaluate6-end=====================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
