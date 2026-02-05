package com.example.lcj.jdk8NewSyntax.java8888.methodpre;

import java.util.Comparator;
import java.util.function.*;

import org.junit.Test;

/**
 * 方法的引用让你可以重复使用现有的方法定义，并像lambda一样传递他们，在一些情况下，比起使用lambda表达式，它们似乎更易读，感觉也更自然；
 *
 * 方法的引用的语法，主要有三类
 *
 * 1.指向静态方法的方法引用，例如Integer的parseInt方法 ，可以写成Integer::parseInt
 *
 * 类：：静态方法名
 *
 * 2.指向任意类型实例方法的方法引用，例如String的length方法，写成String::length；
 *
 * 类：：实例方法名
 *
 * 3.指向现有对象的实例方法的方法引用
 *
 * 对象：：实例方法名
 *
 * 构造器的引用：对于一个现有构造函数，你可以利用它的名称和关键字new来创建它的一个引用ClassName::new；
 *
 * 在java8中的函数式接口，提供了，无参构造函数，以及有参构造函数创建实例的方式；构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * @author lichengjian
 * @date 2021/1/15
 */
public class MethodPreTest {

    @Test
    public void test6() {
        /*************** 方法的引用 ****************/
        // 类：：静态方法名
        Comparator<Integer> bb = Integer::compare;
        System.out.println(bb.compare(3, 2));
        Comparator<Integer> cc = (x, y) -> Integer.compare(x, y);
        System.out.println(cc.compare(3, 2));

        Comparator<Integer> dd = (x, y) -> x.compareTo(y);
        System.out.println(dd.compare(3, 2));
        Comparator<Integer> ee = Integer::compareTo;
        System.out.println(ee.compare(3, 2));

        // 类：：实例方法名
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("a", "b"));
        BiPredicate<String, String> bp1 = String::equals;
        System.out.println(bp1.test("a", "b"));

        // 对象：：实例方法名
        Consumer<String> con1 = x -> System.out.println(x);
        con1.accept("abc");
        Consumer<String> con = System.out::println;
        con.accept("abc");

        Emp emp = new Emp("上海", "xiaoMIng", 18);
        Supplier<String> supper1 = () -> emp.getAddress();
        System.out.println(supper1.get());
        Supplier<String> supper = emp::getAddress;
        System.out.println(supper.get());

        /*************** 构造器的引用 ****************/
        // 无参构造函数，创建实例
        Supplier<Emp> supper2 = () -> new Emp();
        Supplier<Emp> supper3 = Emp::new;
        Emp emp1 = supper3.get();
        emp1.setAddress("上海");
        // 一个参数
        Function<String, Emp> fun = address -> new Emp(address);
        Function<String, Emp> fun1 = Emp::new;
        System.out.println(fun1.apply("beijing"));
        // 两个参数
        BiFunction<String, Integer, Emp> bFun = (name, age) -> new Emp(name, age);
        BiFunction<String, Integer, Emp> bFun1 = Emp::new;
        System.out.println(bFun1.apply("xiaohong", 18));

        /**
         * 最后，特别要注意：
         *
         * ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
         *
         * ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
         */

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
