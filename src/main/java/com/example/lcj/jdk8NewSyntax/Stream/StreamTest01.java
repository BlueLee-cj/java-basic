package com.example.lcj.jdk8NewSyntax.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest01 {
    public static void main(String[] args) {

        //对一个包含整数的集合中筛选出所有的偶数，并将其封装成为一个新的List返回
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        List<Integer> evens = new ArrayList<>();
        for (final Integer num : nums) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }

        List<Integer> evens1 = nums.stream().filter(num -> num % 2 == 0 && num == 4 ).collect(Collectors.toList());


        List<Integer> evens2 = nums.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num % 2 == 0;
            }
        }).collect(Collectors.toList());

        /**
         * 先简单解释一下上面这行语句的含义，stream()操作将集合转换成一个流，filter()执行我们自定义的筛选处理，
         * 这里是通过lambda表达式筛选出所有偶数，最后我们通过collect()对结果进行封装处理，
         * 并通过Collectors.toList()指定其封装成为一个List集合返回。
         */

        /**
         * 由上面的例子可以看出，java8的流式处理极大的简化了对于集合的操作，
         * 实际上不光是集合，包括数组、文件等，只要是可以转换成流，我们都可以借助流式处理，
         * 类似于我们写SQL语句一样对其进行操作。java8通过内部迭代来实现对流的处理，
         * 一个流式处理可以分为三个部分：转换成流、中间操作、终端操作。
         * 以集合为例，
         * 1、一个流式处理的操作我们首先需要调用stream()函数将其转换成流，
         * 2、然后再调用相应的中间操作达到我们需要对集合进行的操作，比如筛选、转换等，
         * 3、最后通过终端操作对前面的结果进行封装，返回我们需要的形式。
         */


        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student("刘一", 85));
        stuList.add(new Student("陈二", 90));
        stuList.add(new Student("张三", 98));
        stuList.add(new Student("李四", 88));
        stuList.add(new Student("王五", 83));
        stuList.add(new Student("赵六", 95));
        stuList.add(new Student("孙七", 87));
        stuList.add(new Student("周八", 84));
        stuList.add(new Student("吴九", 100));
        stuList.add(new Student("郑十", 95));

        //需求：列出90分以上的学生姓名，并按照分数降序排序

        //以前的写法，代码较多，每个操作都需要遍历集合
        List<Student> result1 = new ArrayList<>(10);
        //遍历集合获取分数大于90以上的学生并存放到新的List中
        for (Student s : stuList) {
            if (s.getScore() >= 90) {
                result1.add(s);
            }
        }
        //对List进行降序排序
        result1.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //降序排序
                return Integer.compare(s2.getScore(), s1.getScore());
            }
        });
        System.out.println(result1);

        //使用stream的写法
        /*
         * 1.获取集合的stream对象
         * 2.使用filter方法完成过滤
         * 3.使用sort方法完成排序
         * 4.使用collect方法将处理好的stream对象转换为集合对象
         */
        List<Student> result2 = new ArrayList<>(10);
        result2 = stuList.stream()
                .filter(s -> s.getScore() >= 90)
                //.sorted((s1,s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                //使用Comparator中的comparing方法
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .collect(Collectors.toList());
        System.out.println(result2);
    }
}
