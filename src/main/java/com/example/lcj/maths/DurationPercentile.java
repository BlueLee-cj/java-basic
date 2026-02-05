package com.example.lcj.maths;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.HdrHistogram.Histogram;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DurationPercentile {

    public static void main(String[] args) {
        Map<Long, Long> durationMap = new HashMap<>();
        durationMap.put(10000000000L, 1000L);
        durationMap.put(2000000000L, 80000L);
        durationMap.put(600000000000L, 60000L);

        for (long i = 0; i < 600000; i++) {
            durationMap.put(i, i);
        }

        long millis = System.currentTimeMillis();
        Histogram histogram = buildHistogram(durationMap);
        double percentile = calculatePercentile(histogram, 99);
        System.out.println(System.currentTimeMillis() - millis);
        System.out.println("50th Percentile: " + percentile);

        // 计算百分位
        long millis1 = System.currentTimeMillis();
        List<Long> durations = Lists.newArrayList();
        for (Map.Entry<Long, Long> entry : durationMap.entrySet()) {
            long duration = entry.getKey();
            long times = entry.getValue();
            durations
                    .addAll(LongStream.rangeClosed(0, times - 1).mapToObj(index -> duration)
                            .collect(Collectors.toList()));
        }
        System.out.println(calculatePercentile(durations, 99));
        System.out.println(System.currentTimeMillis() - millis1);
    }

    public static Histogram buildHistogram(Map<Long, Long> durationMap) {
        Histogram histogram = new Histogram(1, 60000000000L, 3);
        for (Map.Entry<Long, Long> entry : durationMap.entrySet()) {
            long duration = entry.getKey();
            long count = entry.getValue();
            histogram.recordValueWithCount(duration, count);
        }
        return histogram;
    }

    public static double calculatePercentile(Histogram histogram, int percentile) {
        return histogram.getValueAtPercentile(percentile);
    }


    // 计算百分位数的方法
    public static long calculatePercentile(List<Long> dataList, int percentile) {

        if (dataList.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        // 计算百分位数的索引
        int index = (int) Math.ceil((percentile / 100.0) * dataList.size()) - 1;

        // 获取百分位数的值
        return dataList.get(index);
    }

    public static void main2(String[] args) {
        // 汇总不同完成时间的统计次数
        HashMap<Long, Long> durationMap = new HashMap<>();
        durationMap.put(10L, 10L);
        durationMap.put(20L, 30L);
        long per99Duration = 10;


        List<Item> items = Lists.newArrayList();
        for (Map.Entry<Long, Long> entry : durationMap.entrySet()) {
            long duration = entry.getKey();
            // 剔除 99 分位之后数据
            if (duration > per99Duration) {
                continue;
            }
            long times = entry.getValue();
            items.add(new Item((int) duration, times));
        }
        items.sort(Comparator.comparing(Item::getTimeline));
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item implements Serializable {

        private static final long serialVersionUID = 2255209742495984942L;

        /**
         * 时间轴
         */
        private int timeline;

        /**
         * 次数
         */
        private long times;

        public Item(int timeline) {
            this.timeline = timeline;
        }
    }

}
