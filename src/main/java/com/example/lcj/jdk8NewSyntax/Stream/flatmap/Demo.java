package com.example.lcj.jdk8NewSyntax.Stream.flatmap;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lichengjian
 * @date 2021/10/4
 */
public class Demo {
    public static void main(String[] args) {

        flatMap();

        reduce();
    }

    public static void flatMap() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);

        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        List<List<Integer>> collect = Stream.of(a, b).collect(Collectors.toList());
        // [[1, 2, 3], [4, 5, 6]]
        System.out.println(collect);

        // 将多个集合中的元素合并成一个集合
        List<Integer> mergeList = Stream.of(a, b).flatMap(list -> list.stream()).collect(Collectors.toList());
        // [1, 2, 3, 4, 5, 6]
        System.out.println(mergeList);

        // 通过Builder模式来构建
        Stream<Object> stream = Stream.builder().add("hello").add("hi").add("byebye").build();
    }

    public static void reduce(){
        Stream<String> stream = Stream.of("you", "give", "me", "stop");
        // Optional<T> reduce(BinaryOperator<T> accumulator);
        Optional<String> optional = stream.reduce((before, after) -> before + "," + after);
        optional.ifPresent(System.out::println);    // you,give,me,stop

        List<BigDecimal> list = Arrays.asList(
                new BigDecimal("11.11"),
                new BigDecimal("22.22"),
                new BigDecimal("33.33")
        );
        // 66.66
        BigDecimal sum = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);
    }

}
