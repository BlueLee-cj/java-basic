package com.example.lcj.createObiect.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Student implements Cloneable, Serializable {

    private int id;

    public Student(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }

    public static void main(String[] args) throws Exception {

        Constructor<Student> constructor = Student.class
                .getConstructor(Integer.class);
        Student stu3 = constructor.newInstance(123);

        // д����
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("D:/student.bin"));
        output.writeObject(stu3);
        output.close();

        // ������
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                "D:/student.bin"));
        Student stu5 = (Student) input.readObject();
        System.out.println(stu5);
    }
}
