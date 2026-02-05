package com.example.lcj.socket.custom;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

/**
 * 消息封装类
 */
class SocketPacket {
    // 消息头存储的长度(占 8 字节)
    static final int HEAD_SIZE = 8;

    /**
     * 将协议封装为:协议头 + 协议体
     * @param context 消息体(String 类型)
     * @return byte[]
     */
    public byte[] toBytes(String context) {
        // 协议体 byte 数组
        byte[] bodyByte = context.getBytes();
        int bodyByteLength = bodyByte.length;
        // 最终封装对象
        byte[] result = new byte[HEAD_SIZE + bodyByteLength];
        // 借助 NumberFormat 将 int 转换为 byte[]
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumIntegerDigits(HEAD_SIZE);
        numberFormat.setGroupingUsed(false);
        // 协议头 byte 数组
        byte[] headByte = numberFormat.format(bodyByteLength).getBytes();
        // 封装协议头
        System.arraycopy(headByte, 0, result, 0, HEAD_SIZE);
        // 封装协议体
        System.arraycopy(bodyByte, 0, result, HEAD_SIZE, bodyByteLength);
        return result;
    }

    /**
     * 获取消息头的内容(也就是消息体的长度)
     * @param inputStream
     * @return
     */
    public int getHeader(InputStream inputStream) throws IOException {
        int result = 0;
        byte[] bytes = new byte[HEAD_SIZE];
        inputStream.read(bytes, 0, HEAD_SIZE);
        // 得到消息体的字节长度
        result = Integer.valueOf(new String(bytes));
        return result;
    }
}
