package com.example.lcj.jdk8NewSyntax.Stream;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lichengjian
 * @date 2021/2/10
 */
public class INStreamTest {
    @SuppressWarnings("checkstyle:WhitespaceAfter")
    public static void main(String[] args) {
        List<int[]> objectStream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(1, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}))
                .collect(toList());

        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                        .filter(t -> t[2] % 1 == 0));
        print(objectStream);
    }
    private static void print(List<int[]> list) {
        list.forEach(item -> System.out.println("{" + item[0] + "," + item[1]+ "," + item[2] + "}"));
    }

}
