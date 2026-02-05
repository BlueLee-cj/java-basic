package com.example.lcj.jvm.classLoader.loader;

import java.net.URL;
import java.util.HashMap;

import com.example.lcj.jvm.object.Student;

import sun.misc.Launcher;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/10 12:38
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            System.out.println(String.class.getClassLoader());
            System.out.println(ClassLoader.getSystemClassLoader());
            System.out.println(ClassLoader.getSystemClassLoader().getParent());
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

            System.out.println(Student.class.getClassLoader());
            System.out.println(Student.class.getClassLoader().getParent());
            System.out.println(Student.class.getClassLoader().getParent().getParent());
            URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
            for (java.net.URL url : urLs) {
                System.out.println(url.toExternalForm());
            }
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            System.out.println(HashMap.class.getClassLoader());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
