package com.example.lcj.hystrix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
public class Controller {

    @Autowired
    private HelloServiceWithFallback helloServiceWithFallback;


    @PostMapping("/heart")
    public String test(@RequestBody List<HeartRatePoint> heartRatePointList, @RequestParam double beginDuration,
                       @RequestParam double endDuration) throws InterruptedException {
        String averageHeartRate = getAverageHeartRate(heartRatePointList, beginDuration, endDuration, false);
        return averageHeartRate;
    }

    public static String getAverageHeartRate(List<HeartRatePoint> heartRatePoints, double beginDuration,
            double endDuration, boolean hasUnit) {
        if (CollectionUtils.isEmpty(heartRatePoints) || heartRatePoints.size() <= 2) {
            return "——";
        }

        double averageHeartRate = heartRatePoints.stream()
                .filter(heartRatePoint -> heartRatePoint.getTimeAxis() / 10 > beginDuration
                        && endDuration <= heartRatePoint.getTimeAxis() / 10)
                .mapToInt(HeartRatePoint::getBeatsPerMinute).average().orElse(0);
        if (averageHeartRate <= 0) {
            return "——";
        }
        if (hasUnit) {
            return String.format("%s bpm", (int) averageHeartRate);
        }
        return String.valueOf((int) averageHeartRate);
    }

    @GetMapping("/hystrix/test")
    public String test(Integer times) throws InterruptedException {

        // for (int i = 0; i < times; i++) {
        // RunnAlble runnAlble = new RunnAlble();
        // new Thread(runnAlble).start();
        // }
        return helloServiceWithFallback.hello("ethan!!");
    }

    class RunnAlble implements Runnable {

        @Override
        public void run() {
            try {
                helloServiceWithFallback.hello("ethan!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 构建课程质量评分
     */
    public static String buildCourseHeatScore(Double planHeatScore) {
        if (planHeatScore != null && planHeatScore > 0) {
            return String.format("评分 %.1f", planHeatScore);
        }
        return "暂无评分";
    }

    public static void main1(String[] args) {
        System.out.println(buildCourseHeatScore(-12.36));
    }

    /**
     * Author: luojinping@gotokeep.com
     * Date: 2017/9/21 下午4:50
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HeartRatePoint implements Serializable {

        private static final long serialVersionUID = 2575335391444204971L;

        /**
         * 同 GeoPoint 中的 timestamp，递增整数，0.1s 为单位
         */
        private long timestamp;
        /**
         * 用于画图，去掉暂停间隔时间，0.1s 为单位
         */
        private long timeAxis;
        /**
         * 心率
         */
        private int beatsPerMinute;
        /**
         * 标记终点和暂停点
         * 实际上是暂停后的第一个点，isAfterPause
         */
        @JsonProperty("isPause")
        private boolean isPause;

        public HeartRatePoint(long timestamp, long timeAxis, int beatsPerMinute) {
            this.timestamp = timestamp;
            this.timeAxis = timeAxis;
            this.beatsPerMinute = beatsPerMinute;
        }
    }


    public static void main(String[] args) {
        HeartRatePoint point = new HeartRatePoint();
        point.setBeatsPerMinute(11);
        HeartRatePoint point2 = new HeartRatePoint();
        point.setBeatsPerMinute(15);
        HeartRatePoint point3 = new HeartRatePoint();
        point.setBeatsPerMinute(18);
        HeartRatePoint point4 = new HeartRatePoint();
        point.setBeatsPerMinute(12);
        ArrayList<HeartRatePoint> integers = Lists.newArrayList(point, point2, point3, point4);

        LongStream longStream = integers.stream().mapToLong(HeartRatePoint::getBeatsPerMinute);
        System.out.println(longStream.max().orElse(0));
        System.out.println(longStream.min().orElse(0));
    }

}
