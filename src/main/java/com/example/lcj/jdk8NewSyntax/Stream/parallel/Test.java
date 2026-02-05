package com.example.lcj.jdk8NewSyntax.Stream.parallel;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author lichengjian
 * @date 2021/2/10
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        Stream.iterate(1, i -> i + 1).limit(10).parallel().forEach(
                System.out::println);

        System.out.println("Sequential sum done in:" + measureSumPerf(Test::sequentialSum, 10000000) + " msecs");
        System.out.println(
                "Iterative sum done in:" + measureSumPerf(Test::iterativeSum, 10_000_000) + " msecs");
        System.out.println(
                "parallelSum sum done in:" + measureSumPerf(Test::parallelSum, 10_000_000) + " msecs");
        System.out.println(
                "rangedSum sum done in:" + measureSumPerf(Test::rangedSum, 10_000_000) + " msecs");
        System.out.println(
                "parallelRangedSum sum done in:" + measureSumPerf(Test::parallelRangedSum, 10_000_000) + " msecs");
        System.out.println(
                "sideEffect sum done in:" + measureSumPerf(Test::sideEffectSum, 10_000_000) + " msecs");

        System.out.println(
                "sideEffectParallelSum sum done in:" + measureSumPerf(Test::sideEffectParallelSum, 10_000_000)
                        + " msecs");

        System.out.println("ForkJoin sum done in: " + measureSumPerf(
                ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs");
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }


    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }


    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1000000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
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
