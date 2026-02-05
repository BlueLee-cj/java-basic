package com.example.lcj.collections.ComparableAndComparator;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/12 15:29
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 3, 4};
        Arrays.sort(a);

        Student[] ss = new Student[4];
        ss[0] = new Student("lc1", 1);
        ss[1] = new Student("lc2", 8);
        ss[2] = new Student("lc3", 2);
        ss[3] = new Student("lc4", 4);


        // Arrays.sort(ss);
        // System.out.println(Arrays.toString(ss));

        long[] aa = new long[4];
        System.out.println(Arrays.toString(aa));
        System.out.println(aa[3]);

        double originalValue = 7.25;

        // 使用 Math.ceil() 进行向上取整
        double roundedUpValue = Math.ceil(originalValue/15);

        System.out.println("原始值: " + originalValue);
        System.out.println("向上取整后的值: " + roundedUpValue);


        List<Student> collect = IntStream.rangeClosed(0, 23).mapToObj(timeline -> new Student("name", timeline)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
