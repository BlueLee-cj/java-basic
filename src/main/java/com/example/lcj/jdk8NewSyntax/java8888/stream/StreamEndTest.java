package com.example.lcj.jdk8NewSyntax.java8888.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class StreamEndTest {
    @Test
    public void forEachTest() {
        List<String> strs = Arrays.asList("a", "b", "c");
        strs.stream().forEachOrdered(System.out::print);// abc
        System.out.println();
        strs.stream().forEach(System.out::print);// abc
        System.out.println();
        strs.parallelStream().forEachOrdered(System.out::print);// abc
        System.out.println();
        strs.parallelStream().forEach(System.out::print);// bca
    }

    @Test
    public void toArrayTest() {
        List<String> strs = Arrays.asList("a", "b", "c");
        String[] dd = strs.stream().toArray(str -> new String[strs.size()]);
        String[] dd1 = strs.stream().toArray(String[]::new);
        Object[] obj = strs.stream().toArray();

        String[] dd2 = strs.toArray(new String[strs.size()]);
        Object[] obj1 = strs.toArray();
    }

    /**
     * count方法，跟List接口的size一样，返回的都是这个集合流的元素的长度，
     *
     * 不同的是，流是集合的一个高级工厂，中间操作是工厂里的每一道工序，我们对这个流操作完成后，可以进行元素的数量的和；
     *
     * 剩下的三个方法，传入的都是Predicate的函数式接口，接口定义请看《JAVA8 Predicate接口》；
     *
     * anyMatch表示，判断的条件里，任意一个元素成功，返回true
     *
     * allMatch表示，判断条件里的元素，所有的都是，返回true
     *
     * noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true
     */

    @Test
    public void countTest() {
        List<String> strs = Arrays.asList("a", "a", "a", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> str.equals("a"));
        long count = strs.stream().filter(str -> str.equals("a")).count();
        System.out.println(aa);// TRUE
        System.out.println(bb);// FALSE
        System.out.println(cc);// FALSE
        System.out.println(count);// 4

        List<String> list = new ArrayList<>();
        boolean allMatch = list.stream().allMatch(e -> e.equals("a"));
        boolean anyMatch = list.stream().anyMatch(e -> e.equals("a"));
        boolean noneMatch = list.stream().noneMatch(e -> e.equals("a"));
        System.out.println(allMatch);// true
        System.out.println(anyMatch);// false
        System.out.println(noneMatch);// true

    }

    /**
     * reduce 是一种归约操作，将流归约成一个值的操作叫做归约操作，用函数式编程语言的术语来说，这种称为折叠（fold）；
     */
    @Test
    public void reduceTest() {
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
        Integer aa = 0;
        for (Integer i : numbers) {
            aa += i;
        }
        Integer dd = numbers.stream().reduce(0, (a, b) -> a + b, (a, b) -> a - b);
        Optional<Integer> dd1 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(aa);
        System.out.println(dd);
        System.out.println(dd1.get());
    }

    public static List<Emp> list = new ArrayList<>();
    static {
        list.add(new Emp("上海", "小名", 17));
        list.add(new Emp("北京", "小红", 18));
        list.add(new Emp("深圳", "小蓝", 19));
        list.add(new Emp("广州", "小灰", 20));
        list.add(new Emp("杭州", "小黄", 21));
        list.add(new Emp("贵阳", "小白", 22));
    }

    @Test
    public void collectTest() {
        // 转list
        List<String> names = list.stream().map(emp -> emp.getName()).collect(Collectors.toList());
        // 转set
        Set<String> address = list.stream().map(emp -> emp.getName()).collect(Collectors.toSet());
        // 转map，需要指定key和value，Function.identity()表示当前的Emp对象本身
        Map<String, Emp> map = list.stream().collect(Collectors.toMap(Emp::getName, Function.identity()));
        // 计算元素中的个数
        Long count = list.stream().collect(Collectors.counting());
        // 数据求和 summingInt summingLong，summingDouble
        Integer sumAges = list.stream().collect(Collectors.summingInt(Emp::getAge));
        // 平均值 averagingInt,averagingDouble,averagingLong
        Double aveAges = list.stream().collect(Collectors.averagingInt(Emp::getAge));

        // 综合处理的，求最大值，最小值，平均值，求和操作
        // summarizingInt，summarizingLong,summarizingDouble
        IntSummaryStatistics intSummary = list.stream().collect(Collectors.summarizingInt(Emp::getAge));
        System.out.println(intSummary.getAverage());// 19.5
        System.out.println(intSummary.getMax());// 22
        System.out.println(intSummary.getMin());// 17
        System.out.println(intSummary.getSum());// 117

        // 连接字符串,当然也可以使用重载的方法，加上一些前缀，后缀和中间分隔符
        String strEmp = list.stream().map(emp -> emp.getName()).collect(Collectors.joining());
        String strEmp1 = list.stream().map(emp -> emp.getName()).collect(Collectors.joining("-中间的分隔符-"));
        String strEmp2 = list.stream().map(emp -> emp.getName()).collect(Collectors.joining("-中间的分隔符-", "前缀*", "&后缀"));
        System.out.println(strEmp);// 小名小红小蓝小灰小黄小白
        // 小名-中间的分隔符-小红-中间的分隔符-小蓝-中间的分隔符-小灰-中间的分隔符-小黄-中间的分隔符-小白
        System.out.println(strEmp1);
        // 前缀*小名-中间的分隔符-小红-中间的分隔符-小蓝-中间的分隔符-小灰-中间的分隔符-小黄-中间的分隔符-小白&后缀
        System.out.println(strEmp2);
        // maxBy 按照比较器中的比较结果刷选 最大值
        Optional<Integer> maxAge = list.stream().map(emp -> emp.getAge())
                .collect(Collectors.maxBy(Comparator.comparing(Function.identity())));
        // 最小值
        Optional<Integer> minAge = list.stream().map(emp -> emp.getAge())
                .collect(Collectors.minBy(Comparator.comparing(Function.identity())));
        System.out.println("max:" + maxAge);
        System.out.println("min:" + minAge);

        // 归约操作
        list.stream().map(emp -> emp.getAge()).collect(Collectors.reducing((x, y) -> x + y));
        list.stream().map(emp -> emp.getAge()).collect(Collectors.reducing(0, (x, y) -> x + y));
        // 分操作 groupingBy 根据地址，把原list进行分组
        Map<String, List<Emp>> mapGroup = list.stream().collect(Collectors.groupingBy(Emp::getAddress));
        // partitioningBy 分区操作 需要根据类型指定判断分区
        Map<Boolean, List<Integer>> partitioningMap = list.stream().map(emp -> emp.getAge())
                .collect(Collectors.partitioningBy(emp -> emp > 20));

    }



    static class Emp {
        private String address;

        private String name;

        private Integer age;

        public Emp() {

        }

        public Emp(String address) {
            this.address = address;
        }

        public Emp(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Emp(String address, String name, Integer age) {
            super();
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Emp [address=" + address + ", name=" + name + ", age=" + age + "]";
        }
    }

}
