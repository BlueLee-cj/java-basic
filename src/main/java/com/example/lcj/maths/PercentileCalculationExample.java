package com.example.lcj.maths;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PercentileCalculationExample {
    public static void main(String[] args) {
        List<Double> dataList = Arrays.asList(15.0, 20.0, 35.0, 35.0, 35.0, 35.0, 35.0, 35.0, 40.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 60.0);

        // 对集合进行排序
        Collections.sort(dataList);

        // 计算百分位数（例如：第75百分位数）
        double percentile10 = calculatePercentile(dataList, 10);
        double percentile90 = calculatePercentile(dataList, 90);
        double percentile98 = calculatePercentile(dataList, 98);
        double percentile99 = calculatePercentile(dataList, 99);

        // 打印结果
        System.out.println("Sorted Data List: " + dataList);
        System.out.println("10th-90th Percentile: " + percentile10 + "-" + percentile90);
        System.out.println("98th Percentile: " + percentile98);
        System.out.println("99th Percentile: " + percentile99);
    }

    // 计算百分位数的方法
    private static double calculatePercentile(List<Double> dataList, int percentile) {
        if (dataList.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        // 计算百分位数的索引
        int index = (int) Math.ceil((percentile / 100.0) * dataList.size()) - 1;

        // 获取百分位数的值
        return dataList.get(index);
    }
}
