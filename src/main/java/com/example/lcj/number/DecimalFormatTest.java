package com.example.lcj.number;

/**
 * 0	必须显示的数字，不足位补 0
 * #	可选显示的数字，不足位不显示
 * .	小数点
 * ,	分组分隔符（通常用于千分位）
 * %	将数值乘以 100 并显示为百分数
 * E	指数符号，用于科学计数法
 * '	引号，用于转义特殊字符
 */

import java.text.DecimalFormat;

    public class DecimalFormatTest {
        public static void main(String[] args) {
            double value = 12345.6789;

            DecimalFormat df = new DecimalFormat("#.##"); // 保留两位小数
            System.out.println(df.format(value)); // 输出：12345.68

            DecimalFormat df2 = new DecimalFormat("0.00"); // 保留两位小数，补齐不足位
            System.out.println(df2.format(123)); // 输出：12345.68

            DecimalFormat df3 = new DecimalFormat("#,###.##"); // 加上千分位
            System.out.println(df3.format(value)); // 输出：12,345.68

            DecimalFormat df4 = new DecimalFormat("0.00");  // 保留两位小数，不足补0
            System.out.println(df4.format(5.2)); // 输出：5.20

            DecimalFormat df5 = new DecimalFormat("#.##");  // 保留最多两位小数，不足不补
            System.out.println(df5.format(5.2)); // 输出：5.2

            DecimalFormat d6 = new DecimalFormat("0000.00"); // 整数部分不足补0
            System.out.println(d6.format(12.3)); // 输出：0012.30

            DecimalFormat df7 = new DecimalFormat("#,###.00"); // 千分位和小数点
            System.out.println(df7.format(1234567.89)); // 输出：1,234,567.89
            System.out.println(df7.format(67.8)); // 输出：67.80
        }
    }
