package com.example.lcj.jdk8NewSyntax.lambda.more.lambdaSimple;

import com.example.lcj.jdk8NewSyntax.lambda.more.Apple;
import com.example.lcj.jdk8NewSyntax.lambda.more.Color;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/8 9:36
 */
public class NewUse {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        // 筛选苹果
        List<Apple> filterApples = filterApplesByAppleFilter(apples, new AppleFilter() {
            @Override
            public boolean accept(Apple apple) {
                // 筛选重量大于100g的红苹果
                return Color.RED.equals(apple.getColor()) && apple.getWeight() > 100;
            }
        });

        /**
         * 行为参数化方式采用匿名类来实现，这样的设计在jdk内部也经常采用，比如java.util.Comparator，java.util.concurrent.Callable等，
         * 使用这一类接口的时候，我们都可以在具体调用的地方用过匿名类来指定函数的具体执行逻辑，
         * 不过从上面的代码块来看，虽然很极客，但是不够简洁，在java8中我们可以通过lambda来简化：
         */

        // 筛选苹果
        List<Apple> filterApples1 = filterApplesByAppleFilter(apples,
                (Apple apple) -> Color.RED.equals(apple.getColor()) && apple.getWeight() >= 100);
        //lambda表达式的使用需要借助于函数式接口，也就是说只有函数式接口出现地方，我们才可以将其用lambda表达式进行简化。
        /**
         * 函数式接口定义为只具备 一个抽象方法 的接口。java8在接口定义上的改进就是引入了默认方法，使得我们可以在接口中对方法提供默认的实现，
         * 但是不管存在多少个默认方法，只要具备一个且只有一个抽象方法，那么它就是函数式接口，如下（引用上面的AppleFilter）
         */

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        list.add(null);
//        list.add(null);

        //1、Predicate的功能类似于上面的AppleFilter，利用我们在外部设定的条件对于传入的参数进行校验，并返回验证结果boolean，下面利用Predicate对List集合的元素进行过滤：
        List<String> res = filter(list, (String str) -> null != str && !str.isEmpty());

        //2、Consumer提供了一个accept抽象函数，该函数接收参数，但不返回值
        filter(list, (String str) -> {
            if (StringUtils.isNotBlank(str)) {
                System.out.println(str);
            }
        });

        //3、Funcation执行转换操作，输入是类型T的数据，返回R类型的数据，
        filter(list, (String str) -> Integer.parseInt(str));

        /* ... 省略apples的初始化操作 */

        //4、采用lambda表达式
        apples.sort((Apple a, Apple b) -> Float.compare(a.getWeight(), b.getWeight()));

        //5、采用方法引用
        apples.sort(Comparator.comparing(Apple::getWeight));//方法引用通过::将方法隶属和方法自身连接起来


    }


    /**
     * 将筛选条件封装成接口
     *
     * @param apples
     * @param filter
     * @return
     */
    public static List<Apple> filterApplesByAppleFilter(List<Apple> apples, AppleFilter filter) {
        List<Apple> filterApples = new ArrayList<>();
        for (final Apple apple : apples) {
            if (filter.accept(apple)) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }

    /**
     * 按照指定的条件对集合元素进行过滤
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<T>();
        for (final T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return newList;
    }

    /**
     * 遍历集合，执行自定义行为
     *
     * @param list
     * @param consumer
     * @param <T>
     */
    public static <T> void filter(List<T> list, Consumer<T> consumer) {
        for (final T t : list) {
            consumer.accept(t);
        }
    }


    /**
     * 遍历集合，执行自定义转换操作
     *
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> filter(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<R>();
        for (final T t : list) {
            newList.add(function.apply(t));
        }
        return newList;
    }


}
