package com.example.lcj.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

public class MD5Util {

    // 盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";

    /**
     * 生成md5
     *
     * @param
     * @return
     */
    public static String getMD5(String str) {
        String base = str + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    /**
     * 生成md5
     *
     * @param
     * @return
     */
    public static String getMD52(String str) {
        String base = str;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

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
     * hash 取两位转成 16 进制后得到一个 8 位的数取最后六位，index 是 2-8
     */
    private static final int RADIX_START = 2;

    private static final int RADIX_END = 8;

    /**
     * 进行字符串补齐，使用 0 进行补齐
     */
    private static final int LEFT_PAD_SIZE = 8;

    private static final String PAD_VALUE = "0";

    public static void main(String[] args) {

        System.out.println(StringUtils.substring(DigestUtils.md5DigestAsHex("61a496e34dad100001bc057e".getBytes()), 0, 5)
                + "_61a496e34dad100001bc057e" + "_" + (Long.MAX_VALUE - System.currentTimeMillis()) + "_" + "rn");
        System.out.println(getMD5("111"));
        System.out.println(getMD5("111"));
        System.out.println(getMD52("111"));
        System.out.println(getMD5("61a496e34dad100001bc057e"));
        System.out.println(getMD52("61a496e34dad100001bc057e"));
        System.out.println(getMD52("61a496e34dad100001bc057e"));
        System.out.println(getMD52("61a496e34dad100001bc057f"));
        System.out.println(getMD52("61a496e34dad100001bc057g"));
        System.out.println("61a496e34dad100001bc057g".hashCode());

        String userId = "622d945f47c54b740e7279fb";
        System.out.println(userId.length());
        String idPartHex = userId.substring(HASH_START, HASH_END);
        System.out.println(idPartHex);
        int idPartValue = Integer.parseInt(idPartHex, HASH_RADIX);
        System.out.println(idPartValue);
        String idHash = StringUtils
                .leftPad(Integer.toBinaryString(idPartValue), LEFT_PAD_SIZE, PAD_VALUE)
                .substring(RADIX_START, RADIX_END);
        int idHashValue = Integer.parseInt(idHash, HASH_SIZE);
        String tableNum = StringUtils.leftPad(Integer.toString(idHashValue), HASH_SIZE, PAD_VALUE);

        System.out.println(tableNum);
        System.out.println(Integer.parseInt("622d9283", 16));
        System.out.println(new Date(1647153795000L));
        System.out.println(new Date(1647154000532L));
        System.out.println(md5("A208849559"));
        System.out.println(getMD52("A208849560"));
        System.out.println("61a496e34dad100001bc057e_".length());
    }

    private static String md5(String phone) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
            md5.update(phone.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (byte b : md5.digest()) {
                buffer.append(String.format("%02x", b));
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
