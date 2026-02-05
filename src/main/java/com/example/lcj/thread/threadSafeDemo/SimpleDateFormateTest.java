package com.example.lcj.thread.threadSafeDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过查看源码发现，原来SimpleDateFormat类内部有一个Calendar对象引用,它用来储存和这个SimpleDateFormat相关的日期信息,
 * 例如sdf.parse(dateStr),sdf.format(date) 诸如此类的方法参数传入的日期相关String,Date等等,
 * 都是交由Calendar引用来储存的.这样就会导致一个问题,如果你的SimpleDateFormat是个static的,
 * 那么多个thread 之间就会共享这个SimpleDateFormat, 同时也是共享这个Calendar引用。
 * 单例、多线程、又有成员变量（这个变量在方法中是可以修改的），这个场景是不是很像servlet，
 * 在高并发的情况下，容易出现幻读成员变量的现象，故说SimpleDateFormat是线程不安全的对象。
 * ps：servlet因是线程不安全的，所以我们使用servlet的原则是不设置成员变量。
 * SimpleDateFormat的parse方法：
 * Calendar是用来承载字符串转化成日期对象的容器，calendar对象有个clear后set值的过程，
 * 高并发下，set值的过程，会出现把上次set值给覆盖的情况
 * 原文链接：https://blog.csdn.net/csdn_ds/article/details/72984646
 */
public class SimpleDateFormateTest extends Thread {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String name;
    private String dateStr;

    public SimpleDateFormateTest(String name, String dateStr) {
        this.name = name;
        this.dateStr = dateStr;
    }

    @Override
    public void run() {

        try {
            Date date = sdf.parse(dateStr);
            System.out.println(name + ": date:" + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new SimpleDateFormateTest("A", "2017-06-10"));
        executorService.execute(new SimpleDateFormateTest("B", "2016-06-06"));
        executorService.shutdown();
    }
}
