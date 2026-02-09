package com.example.lcj.jvm;

import java.util.List;

public class JvmStackDemo {
    public int add(int a, int b) {
        return a + b;
    }
    public static void staticMethod() {}      // invokestatic
    private void privateMethod() {}           // invokespecial
    public void instanceMethod() {}           // invokevirtual

    public void test(List<String> list) {
        staticMethod();                       // invokestatic
        privateMethod();                      // invokespecial
        instanceMethod();                     // invokevirtual
        list.add("hello");                    // invokeinterface
        Runnable r = () -> {};                // invokedynamic
    }
}

/**
 * public class com.example.lcj.jvm.JvmStackDemo {
 *   public com.example.lcj.jvm.JvmStackDemo();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public int add(int, int);
 *     Code:
 *        0: iload_1
 *        1: iload_2
 *        2: iadd
 *        3: ireturn
 * }
 *
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  javap -c Demo.class                                                    │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │                                                                         │
 * │  public int add(int, int);                                              │
 * │    Code:                                                                │
 * │       0: iload_1        // 加载局部变量[1]（参数a）到操作数栈           │
 * │       1: iload_2        // 加载局部变量[2]（参数b）到操作数栈           │
 * │       2: iadd           // 弹出栈顶两个int，相加，结果压栈              │
 * │       3: ireturn        // 返回栈顶的int值                              │
 * │                                                                         │
 * │  执行过程：                                                             │
 * │  ┌─────────────────────────────────────────────────────────────────┐   │
 * │  │  局部变量表: [this, a=3, b=5]                                   │   │
 * │  │                                                                 │   │
 * │  │  iload_1  →  操作数栈: [3]                                      │   │
 * │  │  iload_2  →  操作数栈: [3, 5]                                   │   │
 * │  │  iadd     →  操作数栈: [8]                                      │   │
 * │  │  ireturn  →  返回 8                                             │   │
 * │  └─────────────────────────────────────────────────────────────────┘   │
 * │                                                                         │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │                                                                         │
 * │  ┌────────────┬────────────────────────────────────────────────────┐   │
 * │  │    类别    │                    常见指令                        │   │
 * │  ├────────────┼────────────────────────────────────────────────────┤   │
 * │  │  加载存储  │  iload, istore, aload, astore, ldc, iconst        │   │
 * │  │  算术运算  │  iadd, isub, imul, idiv, irem, ineg               │   │
 * │  │  类型转换  │  i2l, i2f, l2i, f2d, i2b, i2c                     │   │
 * │  │  对象操作  │  new, newarray, getfield, putfield                │   │
 * │  │  栈操作    │  pop, dup, swap                                    │   │
 * │  │  控制转移  │  ifeq, ifne, goto, tableswitch, lookupswitch      │   │
 * │  │  方法调用  │  invokevirtual, invokespecial, invokestatic,      │   │
 * │  │           │  invokeinterface, invokedynamic                    │   │
 * │  │  返回     │  ireturn, lreturn, areturn, return                 │   │
 * │  │  异常     │  athrow                                            │   │
 * │  │  同步     │  monitorenter, monitorexit                         │   │
 * │  └────────────┴────────────────────────────────────────────────────┘   │
 * │                                                                         │
 * │  指令前缀含义：                                                         │
 * │  i = int, l = long, f = float, d = double, a = reference               │
 * │  b = byte, c = char, s = short                                         │
 * │                                                                         │
 * └─────────────────────────────────────────────────────────────────────────┘
 */
