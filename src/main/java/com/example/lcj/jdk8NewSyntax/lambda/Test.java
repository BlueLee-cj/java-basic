package com.example.lcj.jdk8NewSyntax.lambda;

import com.example.lcj.jdk8NewSyntax.Stream.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/7 22:16
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 0");
            }
        }).start();
        //　使用Lambda表达式则只需要使用一句话就可代替上面使用匿名类的方式。
        new Thread(() -> System.out.println("Hello world 1")).start();
        //在这个例子中，传统的语法规则，我们是将一个匿名内部类作为参数进行传递，我们实现了Runnable接口，并将其作为参数传递给Thread类，
        // 这实际上我们传递的是一段代码，也即我们将代码作为了数据进行传递，这就带来许多不必要的“样板代码”。
        //能够接收Lambda表达式的参数类型，是一个只包含一个方法的接口。只包含一个方法的接口称之为“函数接口”。

        //更大的好处则是集合API的更新，新增的Stream类库，使得我们在遍历使用集合时不再像以往那样不断地使用for循环。
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("lcj", 12));
        studentList.add(new Student("lcj", 11));
        studentList.add(new Student("ldy", 13));
        int count = 0;
        for (Student student : studentList) {
            if (student.getName().equals("lcj")) {
                count++;
            }
        }
        long countJdk8 = studentList.stream().filter((student -> student.getName().equals("chengdu"))).count();

        //实战1：线程
        // Java8之前：
        new Thread(new Runnable() {
            public void run() {
                System.out.println("hello world");
            }
        }).start();

        // Java8方式：
        new Thread(() -> System.out.println("hello world")).start();

        //实战2：集合元素的遍历
        // Java8之前：
        List<String> list1 = Arrays.asList("a", "b", "c", "d");
        for (String str : list1) {
            System.out.println(str);
        }

        // Java 8之后：
        List list2 = Arrays.asList("a", "b", "c", "d");
        list2.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        list2.forEach(System.out::println);

        //实战3：map函数。map函数可以说是函数式编程里最重要的一个方法了。map的作用是将一个对象变换为另外一个。
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        cost.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));

        //实战4： reduce函数。map的作用是将一个对象变为另外一个，而reduce实现的则是将所有值合并为一个。
        double allCost = cost.stream().map(x -> x + x * 0.05).reduce((sum, x) -> sum + x).get();
        System.out.println(allCost);


        //实战5：过滤
        List<Double> cos = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filteredCost = cos.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));

        //实战6：Predicate过滤
        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        System.out.println("Language starts with J: ");
        filter(languages, x -> x.startsWith("J"));
        System.out.println("\nLanguage ends with a: ");
        filter(languages, x -> x.endsWith("a"));
        System.out.println("\nAll languages: ");
        filter(languages, x -> true);
        System.out.println("\nNo languages: ");
        filter(languages, x -> false);
        System.out.println("\nLanguage length bigger three: ");
        filter(languages, x -> x.length() > 4);
    }

    public static void filter(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }
}
