package com.example.lcj.jdk8NewSyntax.jdk8map;

import com.example.lcj.jdk8NewSyntax.Stream.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest02 {

    public static void main(String[] args) {
        //初始化List数据同上
        List<Student> list = new ArrayList<>(10);
        list.add(new Student("刘一", 85));
        list.add(new Student("陈二2", 90));
        list.add(new Student("张三34", 98));
        list.add(new Student("李四456", 88));
        list.add(new Student("王五666", 83));
        list.add(new Student("赵六55", 95));
        list.add(new Student("孙七777", 87));
        list.add(new Student("周八66", 84));
        list.add(new Student("吴九5", 100));
        list.add(new Student("郑十111", 95));

        //使用map方法获取list数据中的name
        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        //使用map方法获取list数据中的name的长度
        List<Integer> length = list.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
        System.out.println(length);

        //将每人的分数-10
        List<Integer> score = list.stream().map(Student::getScore).map(i -> i - 10).collect(Collectors.toList());
        System.out.println(score);

        //计算学生总分
        Integer totalScore1 = list.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
        System.out.println(totalScore1);

        //计算学生总分，返回Optional类型的数据，改类型是java8中新增的，主要用来避免空指针异常
        Optional<Integer> totalScore2 = list.stream().map(Student::getScore).reduce((a, b) -> a + b);
        System.out.println(totalScore2.get());

        //计算最高分和最低分
        Optional<Integer> max = list.stream().map(Student::getScore).reduce(Integer::max);
        Optional<Integer> min = list.stream().map(Student::getScore).reduce(Integer::min);

        System.out.println(max.get());
        System.out.println(min.get());
    }
}