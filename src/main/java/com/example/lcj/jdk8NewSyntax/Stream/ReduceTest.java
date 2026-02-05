package com.example.lcj.jdk8NewSyntax.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lichengjian
 * @date 2021/2/10
 */
public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 5);
        Integer sum = nums.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        Optional<Integer> sum2 = nums.stream().reduce((a, b) -> (a + b));

        Optional<Integer> max = nums.stream().reduce(Integer::max);
        System.out.println("----max----" + max);

        List<Stud> studs = Arrays.asList(new Stud("lcj", 20), new Stud("ldy", 30));
        Integer sumStud = studs.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
        Integer sumStud1 = studs.stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println("---stud--sum---" + sumStud);

    }
}




