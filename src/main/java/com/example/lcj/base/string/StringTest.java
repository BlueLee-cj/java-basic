package com.example.lcj.base.string;

import org.apache.commons.lang3.StringUtils;

import com.example.lcj.collections.Student;

public class StringTest {
    String str = new String("old");
    char[] ch = {'a', 'b', 'c'};
    private static String str1 = "123";

    public static void main(String[] args) {
        String aa = "xx";

        StringUtils.isAnyEmpty(aa, aa.substring(10, 2));
    }

    public static void main3(String[] args) {
        String a = "a";
        String b = "b";
        String c = a + b;
        String d = "a" + "b" + "c";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123");
        StringBuffer stringBuffer = new StringBuffer(2);
        stringBuffer.append("ww");
        stringBuffer.append("aa");
        stringBuffer.append("ee");
        System.out.println(a.hashCode());
        a = "111";
        System.out.println(a.hashCode());
        System.out.println(a);
        method(a);
        System.out.println(a);

        System.out.println(str1);
        method3();
        System.out.println(str1);

        Student student = new Student();
        student.setAge(666);
        method2(student);
        System.out.println(student.getAge());

    }

    public static void method2(Student student) {
        // student.setAge(666);
        student = new Student();
        student.setAge(888);
    }

    public static void method(String str) {
        str = "222";
    }

    public static void method3() {
        str1 = "321";
    }



    public static void main2(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        new StringBuffer();
        int a = 11_22;
        System.out.println(a);

        String temp = "1,2,3,4,5";
        System.out.println(temp.split(",").length); // 5
        temp = "1,2,3,4,";
        System.out.println(temp.split(",").length); // 4
        System.out.println(temp.split(",", -1).length); // 5
        System.out.println(temp.split(",", -1)[4].equals("")); // true

        String str = "1+2";

        String[] temp1 = str.split("\\D");

        String str1 = "1+2";

        String[] temp2 = str.split("");

        String[] temp3 = str.split("\\''");



        String string = "A1B2C3D4E5F6G7H8";
        int[] num = new int[8];
        String[] num_string = string.split("\\D");
        String[] num_string1 = string.split("\\d");
        System.out.println(num_string[0]);
        System.out.println("提取数字后的数组元素为：");
        for (int i = 0; i < num_string.length; i++) {
            num[i] = Integer.parseInt(num_string[i]);
            System.out.print(num[i]);
        }

        // String[] ary = " abc".split("");
        // String a = "0000000101001";
        // String[] split = a.split("");
        // System.out.println(split.length);
    }

    public static void main1(String[] args) {

        String a = "a" + "b" + "c";
        String b = new String("b");
        String temp = "abc";
        String c = temp + "a";

        String str = new String("old");
        char[] ch = {'a', 'b', 'c'};
        StringTest st = new StringTest();
        st.change(str, ch);
        System.out.print(str + " and ");
        System.out.println(ch);
        st.change(st.str, st.ch);
        System.out.print(st.str + " and ");
        System.out.println(st.ch);

        // int temp = (int) 3.9;
        // temp %= 2;
        // System.out.print(temp);

    }

    public void change(String str, char ch[]) {
        str = "new";
        ch[0] = 'n';
    }
}
