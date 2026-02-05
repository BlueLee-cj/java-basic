package com.example.lcj.jdk8NewSyntax.Stream.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class CreateStreamTest {
    public static void main(String[] args) {
        String[] dd = { "a", "b", "c" };

        Arrays.stream(dd).forEach(System.out::print);// abc
        System.out.println();

        Stream.of(dd).forEach(System.out::print);// abc
        System.out.println();

        Arrays.asList(dd).stream().forEach(System.out::print);// abc
        System.out.println();

        // 创建的数据集合的值为泛型T对象；这样一直创建无限个对象的流，也成为无限流；
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::print);// 0123456789
        System.out.println();

        Stream.generate(() -> "x").limit(10).forEach(System.out::print);// xxxxxxxxxx


        System.out.println(buildList(100));
        System.out.println(buildIterate(100));
    }
    /**
     * 1-3，是根据具体的数组或者集合对象，创建的流，在创建流之前，这些对象的大小（长度）已经确认，所以这个种方式的流，也被成为有限流，
     * 而4-5中，创建流的方式，是无限大小的流（generate 最大是Long.MAX_VALUE），也被成为无限流，
     * 那么我们不可能就这样放任对象被无限创建，直到内存溢出，这样的无限流，也是配合limit使用，指定这个流生成的元素的个数，
     * 对于无限流，下面再简单讲个案例，使用传统的方式和无限流的方式，创建一个固定大小的ArrayList，这样大家也会有比较清楚的认识；
     */

    public static List<Integer> buildList(final int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> buildIterate(final int size) {
        return Stream.iterate(1, x -> ++x).limit(size).collect(Collectors.toList());
    }
}
