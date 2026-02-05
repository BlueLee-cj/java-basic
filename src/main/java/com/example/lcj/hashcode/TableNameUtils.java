package com.example.lcj.hashcode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc 分表 utils
 * @Author lichengjian
 * @CreateTime 2021/3/3
 **/
@Slf4j
public class TableNameUtils {

    private TableNameUtils() {}

    private static final String RUNNING_LOG_BRIEF_INFO_NAME = "running_log_brief_info_%s";

    private static final String USER_HEART_RATE_FENCE_NAME = "user_heart_rate_fence_%s";

    private static final String USER_PACE_FENCE_NAME = "user_pace_fence_%s";

    private static final String PRE_TABLE_NAME = "00";

    /**
     * hash 取两位，index 为 6-8
     */
    private static final int HASH_SIZE = 2;

    private static final int HASH_START = 6;

    private static final int HASH_END = 8;

    /**
     * 转成 16 进制
     */
    private static final int HASH_RADIX = 16;

    /**
     * hash 取两位转成 16 进制后得到一个 8 位的数取最后4位，index 是 4-8
     */
    private static final int RADIX_START = 4;

    private static final int RADIX_END = 8;

    /**
     * 进行字符串补齐，使用 0 进行补齐
     */
    private static final int LEFT_PAD_SIZE = 8;

    private static final String PAD_VALUE = "0";


    /**
     * 获取跑步日志简要信息表名，分16张表
     *
     * @param userId 用户 ID
     * @return 对应的表名
     */
    public static String getRunningLogBriefInfoTableName(String userId) {
        return getCollectionName(RUNNING_LOG_BRIEF_INFO_NAME, userId);
    }

    /**
     * 获取用户心率围栏信息表，分16张表
     *
     * @param userId 用户 ID
     * @return 对应的表名
     */
    public static String getUserHeartRateFenceTableName(String userId) {
        return getCollectionName(USER_HEART_RATE_FENCE_NAME, userId);
    }

    /**
     * 获取用户配速围栏信息表，分16张表
     *
     * @param userId 用户 ID
     * @return 对应的表名
     */
    public static String getUserPaceFenceTableName(String userId) {
        return getCollectionName(USER_PACE_FENCE_NAME, userId);
    }


    /**
     * running_log_brief_info简要信息表总共分成了16张表，取 userId 的 7-8 位转成 16 进制的后 4 位来分表，2^4 = 16
     *
     * @param tableName 表名前缀
     * @param userId 用户 ID
     * @return 对应的表名
     */
    private static String getCollectionName(String tableName, String userId) {


        String tableNum;

        try {
            String idPartHex = userId.substring(HASH_START, HASH_END);
            int idPartValue = Integer.parseInt(idPartHex, HASH_RADIX);
            String idHash = StringUtils.leftPad(Integer.toBinaryString(idPartValue), LEFT_PAD_SIZE, PAD_VALUE)
                    .substring(RADIX_START, RADIX_END);
            int idHashValue = Integer.parseInt(idHash, HASH_SIZE);
            tableNum = StringUtils.leftPad(Integer.toString(idHashValue), HASH_SIZE, PAD_VALUE);
        } catch (NumberFormatException e) {
            return null;
        }

        if (tableNum == null) {
            return null;
        }
        return String.format(tableName, tableNum);
    }

    public static void main(String[] args) {
        System.out.println(getRunningLogBriefInfoTableName("656467695a75f300014bffec"));
        System.out.println(NumberUtils.toLong(Double.toString(11.2)));
        System.out.println(Long.parseLong(Double.valueOf(11.2).toString()));

    }

    public static final String WEEK_FORMAT = "yyyy-MM-dd";

    /**
     * 是否在本周或者上周
     *
     * @param mondayOfweek yyyy-MM-dd 周一
     * @return
     */
    public static boolean isThisOrLastWeek(String mondayOfweek) {
        String thisWeek = LocalDate.now().with(DayOfWeek.MONDAY).format(DateTimeFormatter.ofPattern(WEEK_FORMAT));
        if (StringUtils.equalsIgnoreCase(thisWeek, mondayOfweek)) {
            return true;
        }

        String lastWeek =
                LocalDate.now().minusWeeks(1).with(DayOfWeek.MONDAY).format(DateTimeFormatter.ofPattern(WEEK_FORMAT));
        return StringUtils.equalsIgnoreCase(lastWeek, mondayOfweek);
    }
}
