package com.example.lcj.createObiect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Student implements Cloneable, Serializable {

    private int id;

    public Student() {

    }

    public Student(Integer id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }

    public static void main(String[] args) throws Exception {

        System.out.println("ʹ��new�ؼ��ִ�������");
        Student stu1 = new Student(123);
        System.out.println(stu1);
        System.out.println("\n---------------------------\n");


        System.out.println("ʹ��Class���newInstance������������");
        Student stu2 = Student.class.newInstance();    //��Ӧ���������޲ι��췽������ֻ����һ�ִ�����ʽ
        System.out.println(stu2);
        System.out.println("\n---------------------------\n");

        System.out.println("ʹ��Constructor���newInstance������������");
        Constructor<Student> constructor = Student.class
                .getConstructor(Integer.class);   // �����вι��췽��
        Student stu3 = constructor.newInstance(123);
        System.out.println(stu3);
        System.out.println("\n---------------------------\n");

        System.out.println("ʹ��Clone������������");
        Student stu4 = (Student) stu3.clone();
        System.out.println(stu4);
        System.out.println("\n---------------------------\n");

        System.out.println("ʹ��(��)���л����ƴ�������");
        // д����
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("student.bin"));
        output.writeObject(stu4);
        output.close();

        // ��ȡ����
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "student.bin"));
        Student stu5 = (Student) input.readObject();
        System.out.println(stu5);

    }
}