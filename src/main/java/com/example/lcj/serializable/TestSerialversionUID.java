package com.example.lcj.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialversionUID {

    public static void main(String[] args) throws Exception {
        SerializeCustomer();// ���л�Customer����
        Customer customer = DeserializeCustomer();// ������Customer����
        System.out.println(customer);
    }

    /**
     * MethodName: SerializeCustomer
     * Description: ���л�Customer����
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @author xudp
     */
    private static void SerializeCustomer() throws FileNotFoundException,
            IOException {
        Customer customer = new Customer("gacl", 25);
        // ObjectOutputStream ���������
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Customer.txt")));
        oo.writeObject(customer);
        System.out.println("Customer�������л��ɹ���");
        oo.close();
    }

    /**
     * MethodName: DeserializeCustomer
     * Description: ������Customer����
     *
     * @return
     * @throws Exception
     * @throws IOException
     * @author xudp
     */
    private static Customer DeserializeCustomer() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/Customer.txt")));
        Customer customer = (Customer) ois.readObject();
        System.out.println("Customer�������л��ɹ���");
        return customer;
    }
}

