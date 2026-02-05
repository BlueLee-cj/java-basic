package com.example.lcj.thread.simpledateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @author ：lcj
 * @description：
 * SimpleDateFormat 是线程不安全的类，一般不要定义为static变量，
 * 如果定义为static，必须加锁，或者使用DateUtils工具类。
 * @date ：Created in 2020/9/12 9:01
 */
public class Test {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        //DateTimeFormatter dateTimeFormatter1 = new DateTimeFormatter("yyyy-MM-dd");
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //dateTimeFormatter1.toString();
        //使用旧的Date对象时，我们用SimpleDateFormat进行格式化显示
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(new Date());
        System.out.println(simpleDateFormat.format(new Date()));

        //使用新的LocalDateTime或ZonedLocalDateTime时，我们要进行格式化显示，就要使用DateTimeFormatter
        //我们只需要记住：因为SimpleDateFormat不是线程安全的，使用的时候，只能在方法内部创建新的局部变量。
        // 而DateTimeFormatter可以只创建一个实例，到处引用。

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm ZZZZ");
        System.out.println(formatter1.format(zdt));

        DateTimeFormatter zhFormatter2 = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm", Locale.CHINA);
        System.out.println(zhFormatter2.format(zdt));

        DateTimeFormatter usFormatter3 = DateTimeFormatter.ofPattern("E, MMMM/dd/yyyy HH:mm", Locale.US);
        System.out.println(usFormatter3.format(zdt));
    }
}
