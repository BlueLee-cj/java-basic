package com.example.lcj.base.unpackpack;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 100;
        int b = a;
        int i = a.intValue();
        Integer integer = Integer.valueOf(1);


        Double d = 200d;
        double f = d;

        Short e = 1;
        short ee = e;

        Long l = 10000000l;
        long ll = l;

        Integer aa = 100;
        Integer bb = 100;
        Integer a1 = 200;
        Integer b1 = 200;
        Integer a2 = new Integer(100);

        System.out.println(aa == bb);
        System.out.println(a1 == b1);
        System.out.println(a == a2);
        System.out.println(a == 100);

        Student student = new Student();
        System.out.println(student.getAge());

        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        // 因为+这个操作符不使用Integer对象，首先i5和i6进行自动拆箱操作，进行数值相加
        // 即i4 == 40；然后i4进行自动拆箱转为int值40 最终40==40比较
        System.out.println(i4 == i5 + i6);
    }
}
///**
//Compiled from "IntegerTest.java"
//public class com.example.lcj.base.unpackpack.IntegerTest {
//  public com.example.lcj.base.unpackpack.IntegerTest();
//    descriptor: ()V
//    Code:
//       0: aload_0
//       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//       4: return
//
//  public static void main(java.lang.String[]);
//    descriptor: ([Ljava/lang/String;)V
//    Code:
//       0: bipush        100
//       2: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
//       5: astore_1
//       6: aload_1
//       7: invokevirtual #3                  // Method java/lang/Integer.intValue:()I
//      10: istore_2
//      11: ldc2_w        #4                  // double 200.0d
//      14: invokestatic  #6                  // Method java/lang/DoubleTest.valueOf:(D)Ljava/lang/DoubleTest;
//      17: astore_3
//      18: aload_3
//      19: invokevirtual #7                  // Method java/lang/DoubleTest.doubleValue:()D
//      22: dstore        4
//      24: iconst_1
//      25: invokestatic  #8                  // Method java/lang/Short.valueOf:(S)Ljava/lang/Short;
//      28: astore        6
//      30: aload         6
//      32: invokevirtual #9                  // Method java/lang/Short.shortValue:()S
//      35: istore        7
//      37: ldc2_w        #10                 // long 10000000l
//      40: invokestatic  #12                 // Method java/lang/Long.valueOf:(J)Ljava/lang/Long;
//      43: astore        8
//      45: aload         8
//      47: invokevirtual #13                 // Method java/lang/Long.longValue:()J
//      50: lstore        9
//      52: return
//}
// */
