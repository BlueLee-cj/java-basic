package com.example.lcj.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │                                                                         │
 * │  while (true) {                                                         │
 * │      for (每个连接) {                                                   │
 * │          read();  // 大部分时候返回"没数据"                            │
 * │      }                                                                  │
 * │  }                                                                      │
 * │                                                                         │
 * │  问题：                                                                 │
 * │  1. CPU 空转，不断轮询，CPU 占用 100%                                  │
 * │  2. 大量无效的系统调用                                                 │
 * │  3. 连接越多，轮询开销越大                                             │
 * │                                                                         │
 * │  这就是为什么需要 IO 多路复用！                                        │
 * │                                                                         │
 * └─────────────────────────────────────────────────────────────────────────┘
 * 同步非阻塞 IO 示例（轮询模式）
 * 注意：这不是 Java NIO 的推荐用法，只是演示非阻塞轮询
 */
public class NonBlockingPollingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);  // 设置非阻塞

        List<SocketChannel> clients = new ArrayList<>();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("Non-blocking Polling Server started on port 8080");

        while (true) {
            // accept() 不阻塞，没有连接返回 null
            SocketChannel client = serverChannel.accept();
            if (client != null) {
                client.configureBlocking(false);  // 客户端也设置非阻塞
                clients.add(client);
                System.out.println("Client connected: " + client.getRemoteAddress());
            }

            // 轮询所有客户端
            for (int i = 0; i < clients.size(); i++) {
                SocketChannel channel = clients.get(i);
                buffer.clear();

                // read() 不阻塞，没有数据返回 0 或 -1
                int bytesRead = channel.read(buffer);

                if (bytesRead > 0) {
                    buffer.flip();
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    String request = new String(data);
                    System.out.println("Received: " + request);

                    // 响应
                    String response = "Hello, " + request;
                    channel.write(ByteBuffer.wrap(response.getBytes()));
                } else if (bytesRead == -1) {
                    // 连接关闭
                    channel.close();
                    clients.remove(i);
                    i--;
                }
            }

            // 问题：这里会不断循环，CPU 100%
            // 这就是轮询的缺点！
        }
    }
}
