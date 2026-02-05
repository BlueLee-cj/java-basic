package com.example.lcj.jdk8NewSyntax.beatiful;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author ：lcj
 *         @description： Java 函数相关的编码规则，旨在给广大Java程序员一些编码建议，有助于大家编写出更优雅、更高质、更高效的代码。
 *         这套编码规则，通过在高德采集部门的实践，已经取得了不错的成效。
 * @date ：Created in 2019/11/28 21:54
 */
public class GoodTest {
    public static void main(String[] args) {
        // byte short int long float double char boolean
        // 1 2 4 8 4 8 2 1
        boolean equals = Objects.equals("a", "b");
        Objects.isNull("a");
        System.out.println(equals);
        List<Object> objects = Collections.emptyList();
        Objects.nonNull("a");
        System.out.println(Math.abs(-2147483648));
        // System.out.println(Math.abs(‭11‬));
    }
}
