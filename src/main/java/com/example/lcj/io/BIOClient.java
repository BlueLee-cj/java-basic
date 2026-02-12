package com.example.lcj.io;

import java.io.*;
import java.net.*;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │                                                                         │
 * │  10000 个客户端连接 → 需要 10000 个线程                                │
 * │                                                                         │
 * │  问题：                                                                 │
 * │  1. 内存爆炸：每个线程约 1MB 栈空间，10000 线程 = 10GB                 │
 * │  2. 线程切换开销巨大                                                   │
 * │  3. 大部分线程在阻塞等待，浪费资源                                     │
 * │                                                                         │
 * │  适用场景：连接数少、并发低的场景                                      │
 * │                                                                         │
 * └─────────────────────────────────────────────────────────────────────────┘
 * BIO 客户端示例
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        // 发送数据
        out.write("World".getBytes());
        out.flush();

        // 阻塞读取响应
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        System.out.println("Response: " + new String(buffer, 0, len));

        socket.close();
    }
}
