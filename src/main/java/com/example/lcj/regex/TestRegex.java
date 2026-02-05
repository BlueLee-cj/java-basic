package com.example.lcj.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/1 21:44
 */
public class TestRegex {
    public static void main(String[] args) {
        // method1();
        // method2();
        // method3();
        // method4();
        // method5();
        // method6();
        // method7();
        // method8();
        // method9();
        // method10();
        // method11();
        method13();
    }

    /**
     * 反向引用
     * 它实际上把任何4字符单词的前后用<b>xxxx</b>括起来。实现替换的关键就在于" <b>$1</b> "，它用匹配的分组子串([a-z]{4})替换了$1。
     */
    public static void method13() {
        String s = "the quick brown fox jumps over the lazy dog.";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }

    /**
     * 替换字符串
     */
    public static void method12() {
        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."
    }

    public static void method11() {

        System.out.println("a b c".split("\\s")); // { "a", "b", "c" }
        System.out.println("a b  c".split("\\s")); // { "a", "b", "", "c" }
        String[] split = "a, b ;; c".split("[\\,\\;\\s]+");// { "a", "b", "c" }
        for (String a : split) {
            System.out.print(a + ",");
        }

        System.out.println("    ");

        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }

    /**
     * 这是因为正则表达式默认使用贪婪匹配：任何一个规则，它总是尽可能多地向后匹配，因此，\d+总是会把后面的0包含进来。
     *
     * 要让\d+尽量少匹配，让0*尽量多匹配，我们就必须让\d+使用非贪婪匹配。在规则\d+后面加个?即可表示非贪婪匹配。我们改写正则表达式如下：
     */
    public static void method10() {
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "123"
            System.out.println("group2=" + matcher.group(2)); // "0000"
        }


        Pattern pattern1 = Pattern.compile("(\\d??)(9*)");
        Matcher matcher1 = pattern1.matcher("9999");
        if (matcher1.matches()) {
            System.out.println("group1=" + matcher1.group(1)); // "123"
            System.out.println("group2=" + matcher1.group(2)); // "0000"
        }
    }

    public static void method9() {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(m.group(0));
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }
    }

    /**
     * 正则表达式 规则 可以匹配
     * A 指定字符 A
     * \u548c 指定Unicode字符 和
     * . 任意字符 a，b，&，0
     * \d 数字0~9 0~9
     * \w 大小写字母，数字和下划线 a~z，A~Z，0~9，_
     * \s 空格、Tab键 空格，Tab
     * \D 非数字 a，A，&，_，……
     * \W 非\w &，@，中，……
     * \S 非\s a，A，&，_，……
     *
     * 正则表达式 规则 可以匹配
     * A* 任意个数字符 空，A，AA，AAA，……
     * A+ 至少1个字符 A，AA，AAA，……
     * A? 0个或1个字符 空，A
     * A{3} 指定个数字符 AAA
     * A{2,3} 指定范围个数字符 AA，AAA
     * A{2,} 至少n个字符 AA，AAA，AAAA，……
     * A{0,3} 最多n个字符 空，A，AA，AAA
     *
     * 正则表达式 规则 可以匹配
     * ^ 开头 字符串开头
     * $ 结尾 字符串结束
     * [ABC] […]内任意字符 A，B，C
     * [A-F0-9xy] 指定范围的字符 A，……，F，0，……，9，x，y
     * [^A-F] 指定范围外的任意字符 非A~F
     * AB|CD|EF AB或CD或EF AB，CD，EF
     */
    public static void method8() {
        String regex = "java\\w";
        System.out.println("java_".matches(regex));

        regex = "A\\d*";
        System.out.println("A33".matches(regex));

        regex = "A\\d+";
        System.out.println("A33".matches(regex));

        regex = "A\\d?";
        System.out.println("A33".matches(regex));

        regex = "A\\d{2}";
        System.out.println("A33".matches(regex));

        regex = "A\\d{2,}";
        System.out.println("A1".matches(regex));

        regex = "[^1-9]{3}";
        System.out.println("ABC".matches(regex));
        System.out.println("A1C".matches(regex));

        String re = "java|php";
        System.out.println("java".matches(re));

        String ree = "learn\\s(java|php|go)";
        System.out.println("learn java".matches(ree));
    }

    public static void method7() {
        String regex = "20\\d\\d";
        System.out.println("2019".matches(regex)); // true
        System.out.println("2100".matches(regex)); // false
    }

    public static void method6() {
        String aa = "zz特步 轻便舒适休闲跑鞋 9 83419119188";
        Pattern.matches("", aa);

        String bb = aa.substring(0, aa.lastIndexOf(" "));
        System.out.println(bb + "aaaa");

        String regEx = "^.+?\\d$";

        String regEx1 = "^.+?\\s\\d+\\d$";
        Pattern pattern = Pattern.compile(regEx1);
        Matcher matcher = pattern.matcher(aa);
        System.out.println(matcher.matches());
    }

    public static void method1() {
        String re = "learn\\s(java|php|go)";
        System.out.println("learn java".matches(re));
        System.out.println("learn Java".matches(re));
        System.out.println("learn php".matches(re));
        System.out.println("learn Go".matches(re));
    }

    public static void method2() {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }
    }

    public static void method3() {
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }

    public static void method4() {
        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."
    }

    public static void method5() {
        String s = "the quick brown fox jumps over the lazy dog.";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }
}
