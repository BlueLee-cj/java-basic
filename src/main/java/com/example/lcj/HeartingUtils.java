/* Copyright 2020 Beijing Calorie Information Technology Co. Ltd. */
/* 版权所有 2020 北京卡路里信息技术有限公司 */
package com.example.lcj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author majunjie
 * @date 2018/11/27
 */
public class HeartingUtils {

    private static final List<Heart> HEARTS = Arrays.asList(
            new Heart(1, "", 0.2f, 0.5f),
            new Heart(2, "", 0.5f, 0.6f),
            new Heart(3, "", 0.6f, 0.7f),
            new Heart(4, "", 0.7f, 0.8f),
            new Heart(5, "", 0.8f, 0.9f),
            new Heart(6, "", 0.9f, 1f));

    private static final List<Heart> NEW_HEARTS = Arrays.asList(
            new Heart(1, "放松身体", 0.0f, 0.25f),
            new Heart(2, "暖身激活", 0.25f, 0.45f),
            new Heart(3, "高效燃脂", 0.45f, 0.66f),
            new Heart(4, "心肺提升", 0.66f, 0.79f),
            new Heart(5, "强度冲击", 0.79f, 0.87f),
            new Heart(6, "极限突破", 0.87f, 1f));

    private HeartingUtils() {}

    /**
     * https://phab.gotokeep.com/T86326
     */
    public static List<Heart> getRange(float resting, float max) {
        List<Heart> hearts = new ArrayList<>();

        HEARTS.forEach((heart) -> {
            float start = (int) ((max - resting) * heart.getLowerLimit() + resting);
            float end = (int) ((max - resting) * heart.getUpperLimit() + resting);

            hearts.add(new Heart(heart.getLevel(), heart.getLevelName(), start, end));
        });

        return hearts;
    }

    public static List<Heart> getNewRange(float resting, float max) {
        List<Heart> hearts = new ArrayList<>();

        NEW_HEARTS.forEach((heart) -> {
            float start = (int) ((max - resting) * heart.getLowerLimit() + resting);
            float end = (int) ((max - resting) * heart.getUpperLimit() + resting);

            /**
             * 为了区间更严谨，开区间统一加1
             */
            if (start != 0.0f) {
                start += 1;
            }

            hearts.add(new Heart(heart.getLevel(), heart.getLevelName(), start, end));
        });

        return hearts;
    }

    public static void main(String[] args) {
        List<Heart> newRange = getNewRange(56, 101);
        System.out.println(JSON.toJSON(newRange));
    }

    @AllArgsConstructor
    @Data
    public static class Heart {
        private int level;

        private String levelName;

        private float lowerLimit;

        private float upperLimit;
    }

}
