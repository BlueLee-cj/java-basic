package com.example.lcj.base;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class DemoTest {
    public static void main(String[] args) {
//		main1();
        method2();
    }

    public static void main1() {
        //&���߼��������ȿ��Բ��������ͣ��ֿ��Բ�����ֵ�����������ʽ��ֵ��������λչ������Ӧ��λ(bit)��ֵ���С��롱���㣬��������ڸ�λ��
        int a = 9;
        int b = 8;
        System.out.println(9 & 8);//8
        //&&:����������ֻ�ܲ��������͵�
        char c = 1;
        char d = 0;
        System.out.println(true && false);//false

        //�ַ���ת��
        String str = "";
        try {
            String strtemp = new String(str.getBytes("ISO-8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //equals�����Ƚ�
        Cat cat1 = new Cat(1, 1, 1);
        Cat cat2 = new Cat(1, 1, 1);
        System.out.println(cat1.equals(cat2));

        //Java�й���HashMap��Ԫ�ر�����˳������
        HashMap<String, Cat> hashMap = new HashMap<String, Cat>();
//		hashMap.put("1", cat1);
//		hashMap.put("3", cat2);
//		hashMap.put("2", new Cat(3, 3, 3));
//		for (Entry<String, Cat> entry : hashMap.entrySet()) {
//			System.out.println(MessageFormat.format("{0}={1}", entry.getKey(), entry.getValue()));
//		}
        hashMap.put("1", cat1);
        cat1 = null;
    }

    public static void method1() {
        List<String> list = new ArrayList<String>();
        add(list, 10);
        String s = list.get(0);
    }

    public static void add(List l, Object o) {
        l.add(o);
    }

    public static void method2() {
        StringBuffer sb = new StringBuffer();
        sb.append("bbbb").append("ddd");
        System.out.println(sb);
        System.out.println(sb.toString());
    }
}
