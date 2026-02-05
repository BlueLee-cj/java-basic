package com.example.lcj.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

/**
 * <p>ClassName: TestObjSerializeAndDeserialize<p>
 * <p>Description: ���Զ�������л��ͷ�����<p>
 *
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 ����03:17:25
 */
public class TestObjSerializeAndDeserialize {

    public static void main(String[] args) throws Exception {
        SerializePerson();//���л�Person����
        Person p = DeserializePerson();//������Perons����
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",
                p.getName(), p.getAge(), p.getSex()));
    }

    /**
     * MethodName: SerializePerson
     * Description: ���л�Person����
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @author xudp
     */
    private static void SerializePerson() throws FileNotFoundException,
            IOException {
        Person person = new Person();
        person.setName("gacl");
        person.setAge(25);
        person.setSex("��");
        // ObjectOutputStream �������������Person����洢��E�̵�Person.txt�ļ��У���ɶ�Person��������л�����
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person�������л��ɹ���");
        oo.close();
    }

    /**
     * MethodName: DeserializePerson
     * Description: ������Perons����
     *
     * @return
     * @throws Exception
     * @throws IOException
     * @author xudp
     */
    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/Person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person�������л��ɹ���");
        return person;
    }

}