package com.example.lcj.jdk8NewSyntax.Stream.parallel;

import java.util.stream.LongStream;

/**
 * @author lichengjian
 * @date 2021/2/11
 */
public class CorrectUseParalle {
    public static void main(String[] args) {
        System.out.println(sideEffectSum(10));
        System.out.println(sideEffectParallelSum(10));
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
}
