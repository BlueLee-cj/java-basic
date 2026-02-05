package com.example.lcj.designpattern.builder;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 11:17
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("lcj");
        student.setAge(12);
        student.setGender(1);
        System.out.println(student);
        Student01 ldy = Student01.builder().name("ldy").age(10).gender(0).build();
        System.out.println(ldy);
    }
}
