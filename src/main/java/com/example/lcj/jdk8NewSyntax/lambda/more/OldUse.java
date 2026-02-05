package com.example.lcj.jdk8NewSyntax.lambda.more;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/8 9:31
 */
public class OldUse {
    public static void main(String[] args) {

    }

    /**
     * 筛选绿苹果
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> filterApples = new ArrayList<>();
        for (final Apple apple : apples) {
            if (Color.GREEN.equals(apple.getColor())) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }

    /**
     * 筛选红苹果
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterRedApples(List<Apple> apples) {
        List<Apple> filterApples = new ArrayList<>();
        for (final Apple apple : apples) {
            if (Color.RED.equals(apple.getColor())) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }


    /**
     * 自定义筛选颜色
     *
     * @param apples
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> apples, Color color) {
        List<Apple> filterApples = new ArrayList<>();
        for (final Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }


    /**
     * 筛选指定颜色，且重要符合要求
     *
     * @param apples
     * @param color
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByColorAndWeight(List<Apple> apples, Color color, float weight) {
        List<Apple> filterApples = new ArrayList<>();
        for (final Apple apple : apples) {
            if (color.equals(apple.getColor()) && apple.getWeight() >= weight) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }
    /**
     * ？如果筛选条件越来越多，组合模式越来越复杂，我们是不是需要考虑到所有的情况，并针对每一种情况都有相应的应对策略呢，
     * 并且这些函数仅仅是筛选条件的部分不一样，其余部分都是相同的模板代码（遍历集合），
     * 这个时候我们就可以将行为 参数化 ，让函数仅保留模板代码，而把筛选条件抽离出来当做参数传递进来。
     */


}
