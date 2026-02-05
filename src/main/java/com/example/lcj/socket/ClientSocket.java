package com.example.lcj.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端（只负责发送消息）
 */
public class ClientSocket {
    public static void main(String[] args) throws IOException {
        // 创建 Socket 客户端并尝试连接服务器端
        Socket socket = new Socket("127.0.0.1", 8888);
        // 发送的消息内容
        final String message = "Hi,Java.";
        // 使用输出流发送消息
        try (OutputStream outputStream = socket.getOutputStream()) {
            // 给服务器端发送 10 次消息
            for (int i = 0; i < 10; i++) {
                // 发送消息
                outputStream.write(message.getBytes());
            }
        }
    }
}
