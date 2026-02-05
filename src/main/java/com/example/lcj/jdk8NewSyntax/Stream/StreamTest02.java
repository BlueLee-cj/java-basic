package com.example.lcj.jdk8NewSyntax.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/8 10:35
 */
public class StreamTest02 {
    public static void main(String[] args) {

        // 初始化
        List<Stud> students = new ArrayList<Stud>();
        students.add(new Stud(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
        students.add(new Stud(20160002, "伯约", 20, 2, "信息安全", "武汉大学"));
        students.add(new Stud(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
        students.add(new Stud(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
        students.add(new Stud(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
        students.add(new Stud(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
        students.add(new Stud(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
        students.add(new Stud(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
        students.add(new Stud(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
        students.add(new Stud(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));

        /** ----------------------------------------------filter------------------------------------- */
        /**
         * 在前面的例子中我们已经演示了如何使用filter，其定义为：Stream<T> filter(Predicate<? super T> predicate)，
         * filter接受一个谓词Predicate，我们可以通过这个谓词定义筛选条件，
         * 在介绍lambda表达式时我们介绍过Predicate是一个函数式接口，其包含一个test(T t)方法，该方法返回boolean。
         * 现在我们希望从集合students中筛选出所有武汉大学的学生，那么我们可以通过filter来实现，并将筛选操作作为参数传递给filter
         */
        List<Stud> whuStudents = students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());


        /** ----------------------------------------------distinct------------------------------------- */
        /**
         * distinct操作类似于我们在写SQL语句时，添加的DISTINCT关键字，用于去重处理，
         * distinct基于Object.equals(Object)实现，回到最开始的例子，假设我们希望筛选出所有不重复的偶数，
         * 那么可以添加distinct操作：
         */
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(4);
        nums.add(5);

        List<Integer> evens1 = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

        List<Integer> evens = nums.stream()
                .filter(num -> num % 2 == 0).distinct()
                .collect(Collectors.toList());
        System.out.println(nums);


        /** ----------------------------------------------limit------------------------------------ */
        /**
         * limit操作也类似于SQL语句中的LIMIT关键字，不过相对功能较弱，limit返回包含前n个元素的流，
         * 当集合大小小于n时，则返回实际长度，比如下面的例子返回前两个专业为土木工程专业的学生：
         */
        List<Stud> civilStudents = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor())).limit(2)
                .collect(Collectors.toList());

        /**
         * 说到limit，不得不提及一下另外一个流操作：sorted。该操作用于对流中元素进行排序，
         * sorted要求待比较的元素必须实现Comparable接口，如果没有实现也不要紧，我们可以将比较器作为参数传递给sorted(Comparator<? super T>
         * comparator)，
         * 比如我们希望筛选出专业为土木工程的学生，并按年龄从小到大排序，筛选出年龄最小的两个学生，那么可以实现为：
         *
         */
        List<Stud> sortedCivilStudents = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor())).sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .limit(2)
                .collect(Collectors.toList());

        /**
         * skip操作与limit操作相反，如同其字面意思一样，是跳过前n个元素，比如我们希望找出排序在2之后的土木工程专业的学生，那么可以实现为：
         */
        List<Stud> civilStudents1 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .skip(2)
                .collect(Collectors.toList());

        /**
         * 2.2 映射
         * 在SQL中，借助SELECT关键字后面添加需要的字段名称，可以仅输出我们需要的字段数据，
         * 而流式处理的映射操作也是实现这一目的，在java8的流式处理中，主要包含两类映射操作：map和flatMap。
         * 举例说明，假设我们希望筛选出所有专业为计算机科学的学生姓名，
         * 那么我们可以在filter筛选的基础之上，通过map将学生实体映射成为学生姓名字符串，具体实现如下：
         */

        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Stud::getName).collect(Collectors.toList());

        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(Stud::getAge).sum();

        /**
         * flatMap与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流 。
         * 举例说明，假设我们有一个字符串数组String[] strs = {"java8", "is", "easy", "to", "use"};，
         * 我们希望输出构成这一数组的所有非重复字符，那么我们可能首先会想到如下实现：
         *
         */
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split("")) // 映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());

        List<String> distinctStrs2 = Arrays.stream(strs)
                .map(str -> str.split("")) // 映射成为Stream<String[]>
                .flatMap(Arrays::stream) // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());


        students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());

        Map<String, Stud> addressDTOMap = students.stream()
                .collect(Collectors.toMap(
                        stud -> StringUtils.joinWith("_", stud.getAge(), stud.getSchool()),
                        Function.identity(), (o, n) -> o));
        System.out.println(addressDTOMap);

    }
}
