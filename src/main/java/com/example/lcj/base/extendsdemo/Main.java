package com.example.lcj.base.extendsdemo;

public class Main {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);

        // 原因很明显，因为Pair<Integer>不是Pair<Number>的子类，因此，add(Pair<Number>)不接受参数类型Pair<Integer>。
        // int n = add1(p);
        // System.out.println(n);

        int n = add2(p);
        System.out.println(n);
    }

    static int add1(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static int add2(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static int add3(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();

        // incompatible types: Integer cannot be converted to CAP#1
        // where CAP#1 is a fresh type-variable:
        // CAP#1 extends Number from capture of ? extends Number
        // 编译错误发生在p.setFirst()传入的参数是Integer类型。有些童鞋会问了，既然p的定义是Pair<? extends Number>，那么setFirst(? extends
        // Number)为什么不能传入Integer？
        // 原因还在于擦拭法。如果我们传入的p是Pair<Double>，显然它满足参数定义Pair<? extends
        // Number>，然而，Pair<Double>的setFirst()显然无法接受Integer类型。
        // 这就是<? extends Number>通配符的一个重要限制：方法参数签名setFirst(? extends Number)无法传递任何Number的子类型给setFirst(?
        // extends Number)。
        // 这里唯一的例外是可以给方法参数传入null：
        // p.setFirst(new Integer(first.intValue() + 100));
        p.setFirst(null);
        p.setLast(null);
        return p.getFirst().intValue() + p.getFirst().intValue();
    }
}
