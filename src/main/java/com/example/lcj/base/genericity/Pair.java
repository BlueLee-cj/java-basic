package com.example.lcj.base.genericity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        //
        return first;
    }

    public T getLast() {
        return last;
    }

    // 对静态方法使用<T>:静态方法不能引用泛型类型<T>，必须定义其他类型（例如<K>）来实现静态泛型方法；
    // public static Pair<T> create(T first, T last) {
    // return new Pair<T>(first, last);
    // }

    // 可以编译通过:
    public static <T> Pair<T> create1(T first, T last) {
        return new Pair<T>(first, last);
    }


    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create2(K first, K last) {
        return new Pair<K>(first, last);
    }

    // public boolean equals(T t) {
    // return this == t;
    // }

    public Pair(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }

    public static void main(String[] args) {
        Pair<String> p1 = new Pair<>("Hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.out.println(c1 == c2); // true
        System.out.println(c1 == Pair.class); // true

        Pair<Integer> p = new Pair<>(123, 456);
        // Compile error:
        // if (p instanceof Pair<String>) {
        // System.out.println();
        // }


        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }
    }

}


class IntPair extends Pair<Integer> {
    IntPair(Integer first, Integer last) {
        super(first, last);
    }
}
