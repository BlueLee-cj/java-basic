package com.example.lcj.jdk8NewSyntax.Stream.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class StreamMiddleTest {
    @Test
    public void testFilter() {
        String[] dd = {"a", "b", "c"};
        Stream<String> stream = Arrays.stream(dd);
        stream.filter(str -> str.equals("a")).forEach(System.out::println);// 返回字符串为a的值
    }

    @Test
    public void testMap() {
        Integer[] dd = {1, 2, 3};
        Stream<Integer> stream = Arrays.stream(dd);
        stream.map(str -> Integer.toString(str)).forEach(str -> {
            System.out.println(str);// 1 ,2 ,3
            System.out.println(str.getClass());// class java.lang.String
        });

        List<Emp> list = Arrays.asList(new Emp("a"), new Emp("b"), new Emp("c"));
        list.stream().map(emp -> emp.getName()).forEach(str -> {
            System.out.println(str);
        });

    }

    /**
     * 第一段输出代码里，我们先看map操作，通过上面对map的介绍，我们可以看到，map可以改变返回的Stream的泛型，str.split("")，
     * 根据空字符串分隔，返回的类型是一个数组，返回的流也是Stream<String[]>，而不是Stream<String>；
     * 在第二段代码中，数组的流，经过map操作，返回Stream<String[]>后，再经过flatMap，把数组通过Arrays.stream变成一个新的流，
     * 再返回到原来的流里
     */
    @Test
    public void testFlatMap() {
        String[] strs = {"aaa", "bbb", "ccc"};
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::println);
        // Ljava.lang.String;@53d8d10a
        Arrays.stream(strs).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out::println);
        // aaabbbccc
        Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).forEach(System.out::println);
        // aaabbbccc
    }

    /**
     * //去重复
     * Stream<T> distinct();
     * //排序
     * Stream<T> sorted();
     * //根据属性排序
     * Stream<T> sorted(Comparator<? super T> comparator);
     * //对对象的进行操作
     * Stream<T> peek(Consumer<? super T> action);
     * //截断--取先maxSize个对象
     * Stream<T> limit(long maxSize);
     * //截断--忽略前N个对象
     * Stream<T> skip(long n);
     */

    public static List<Emp> list = new ArrayList<>();

    static {
        list.add(new Emp("xiaoHong1", 20, 1000.0));
        list.add(new Emp("xiaoHong2", 25, 2000.0));
        list.add(new Emp("xiaoHong3", 30, 3000.0));
        list.add(new Emp("xiaoHong4", 35, 4000.0));
        list.add(new Emp("xiaoHong5", 38, 5000.0));
        list.add(new Emp("xiaoHong6", 45, 9000.0));
        list.add(new Emp("xiaoHong7", 55, 10000.0));
        list.add(new Emp("xiaoHong8", 42, 15000.0));
    }

    public static void println(Stream<Emp> stream) {
        stream.forEach(emp -> {
            System.out.println(String.format("名字：%s，年纪：%s，薪水：%s", emp.getName(), emp.getAge(), emp.getSalary()));
        });
    }

    public static void main(String[] args) {
        Emp xx = new Emp("xx", 33, 1000d);
        // 对数组流，先过滤重复，在排序，再控制台输出 1，2，3
        Arrays.asList(3, 1, 2, 1).stream().distinct().sorted().forEach(str -> {
            System.out.println(str);
        });
        // 对list里的emp对象，取出薪水，并对薪水进行排序，然后输出薪水的内容，map操作，改变了Strenm的泛型对象
        Stream<Double> xx1 = list.stream().map(emp -> {
            // xx = new Emp("yy", 44, 3000d);
            System.out.println(xx.getAge());
            System.out.println(xx);
            emp.setSalary(2000d);
            return emp.getSalary();
        }).sorted();
        xx1.forEach(salary -> {
            System.out.println(salary);
        });
        xx1.forEach(salary -> {
            System.out.println(salary);
        });
        xx.setSalary(2000d);
        // 根据emp的属性name，进行排序
        println(list.stream().sorted(Comparator.comparing(Emp::getName)));

        // 给年纪大于30岁的人，薪水提升1.5倍，并输出结果
        Stream<Emp> stream = list.stream().filter(emp -> {
            return emp.getAge() > 30;
        }).peek(emp -> {
            emp.setSalary(emp.getSalary() * 1.5);
        });
        println(stream);
        // 数字从1开始迭代（无限流），下一个数字，是上个数字+1，忽略前5个 ，并且只取10个数字
        // 原本1-无限，忽略前5个，就是1-5数字，不要，从6开始，截取10个，就是6-15
        Stream.iterate(1, x -> ++x).skip(5).limit(10).forEach(System.out::println);

        int a = 1;
        Runnable runnable = () -> System.out.println(a);
    }


    public static class Emp {
        private String name;

        private Integer age;

        private Double salary;

        public Emp(String name) {
            super();
            this.name = name;
        }

        public Emp(String name, Integer age, Double salary) {
            super();
            this.name = name;
            this.age = age;
            this.salary = salary;
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

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

    }

}

