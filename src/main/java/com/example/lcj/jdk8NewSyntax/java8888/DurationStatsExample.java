package com.example.lcj.jdk8NewSyntax.java8888;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DurationStatsExample {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Stats {
        private long duration;
        private long count;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RaceMonthlyStats {
        private List<Stats> durationStats;
    }

    public static void main(String[] args) {
        RaceMonthlyStats stats1 = new RaceMonthlyStats(Lists.newArrayList(new Stats(11, 22)));
        RaceMonthlyStats stats2 = new RaceMonthlyStats(Lists.newArrayList(new Stats(11, 22), new Stats(22, 22)));
        RaceMonthlyStats stats3 = new RaceMonthlyStats(Lists.newArrayList(new Stats(11, 22), new Stats(22, 22)));

        List<RaceMonthlyStats> lists = Lists.newArrayList(stats1, stats2, stats3);

        // 汇总不同完成时间的统计次数
        HashMap<Long, Long> durationMap1 = new HashMap<>();
        HashMap<Long, Long> durationMap2 = new HashMap<>();


        System.out.println(durationMap1.isEmpty());

        stats2.getDurationStats().forEach(d -> {
            long duration = d.getDuration();
            if (duration == 11) {
                return;
            }
            System.out.println(d);
        });

        double[] distances = {50, 150, 250, 350, 450, 550, 650, 750, 850, 950, 1500, 2500, 3500, 4500, 5500};
        for (double distance : distances) {
            System.out.println("距离：" + distance + "米，展示：" + getDistanceDisplay(distance));
        }
    }

    public static String getDistanceDisplay(double distance) {
        if (distance <= 900) {
            int i = ((int) (distance / 100) + 1) * 100;
            return i + " 米以内";
        } else {
            return (int) (distance / 1000) + 1 + " 公里以内";
        }
    }
}
