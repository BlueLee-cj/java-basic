package com.example.lcj.socket.custom;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 服务器端
 */
class MySocketServer {
    public static void main(String[] args) throws IOException {
        // 创建 Socket 服务器端
        ServerSocket serverSocket = new ServerSocket(9093);
        // 获取客户端连接
        Socket clientSocket = serverSocket.accept();
        // 使用线程池处理更多的客户端
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(100, 150, 100,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        threadPool.submit(() -> {
            // 客户端消息处理
            processMessage(clientSocket);
        });
    }
    /**
     * 客户端消息处理
     * @param clientSocket
     */
    private static void processMessage(Socket clientSocket) {
        // Socket 封装对象
        SocketPacket socketPacket = new SocketPacket();
        // 获取客户端发送的消息对象
        try (InputStream inputStream = clientSocket.getInputStream()) {
            while (true) {
                // 获取消息头(也就是消息体的长度)
                int bodyLength = socketPacket.getHeader(inputStream);
                // 消息体 byte 数组
                byte[] bodyByte = new byte[bodyLength];
                // 每次实际读取字节数
                int readCount = 0;
                // 消息体赋值下标
                int bodyIndex = 0;
                // 循环接收消息头中定义的长度
                while (bodyIndex <= (bodyLength - 1) &&
                        (readCount = inputStream.read(bodyByte, bodyIndex, bodyLength)) != -1) {
                    bodyIndex += readCount;
                }
                bodyIndex = 0;
                // 成功接收到客户端的消息并打印
                System.out.println("接收到客户端的信息:" + new String(bodyByte));
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
