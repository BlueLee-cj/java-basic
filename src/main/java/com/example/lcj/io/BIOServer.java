package com.example.lcj.io;

import java.io.*;
import java.net.*;

/**
 * BIO 服务器示例
 * 特点：一个连接一个线程，阻塞等待
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("BIO Server started on port 8080");

        while (true) {
            // accept() 阻塞，直到有客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // 每个连接创建一个线程处理
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try (
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream()
        ) {
            byte[] buffer = new byte[1024];
            int len;

            // read() 阻塞，直到有数据可读
            while ((len = in.read(buffer)) != -1) {
                String request = new String(buffer, 0, len);
                System.out.println("Received: " + request);

                // 处理请求并响应
                String response = "Hello, " + request;
                out.write(response.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
