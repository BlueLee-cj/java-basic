package com.example.lcj.copy.deep.MapStruct.demo1;

import java.util.Date;

/**
 * @author lichengjian
 * @date 2021/12/21
 */
public class Test {
    public static void main(String[] args) {
        testFromSource();
        System.out.println((new Date()).getTime());
        testToSource();
    }

    private static void testFromSource() {
        Source source = new Source(1, "测试基础转换", 1, "haha");
        source.setBirth(Long.valueOf("1640067922203"));
        Target target = ConverterWithExpression.INSTANCE.fromSource(source);
        System.out.println(target);
    }

    private static void testToSource() {
        Target target = new Target(1, "测试基础转换", ComplexEnumType.HAHA);
        target.setBirth(new Date());
        Source source = ConverterWithExpression.INSTANCE.toSource(target);
        System.out.println(source);
    }
}
