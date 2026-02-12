package com.example.lcj.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Java NIO 服务器示例（IO 多路复用）
 * 使用 Selector 监听多个 Channel
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        // 1. 创建 Selector（多路复用器）
        Selector selector = Selector.open();

        // 2. 创建 ServerSocketChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);  // 非阻塞

        // 3. 注册到 Selector，监听 ACCEPT 事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("NIO Server started on port 8080");

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            // 4. select() 阻塞，直到有事件发生
            //    这里不是轮询，而是等待内核通知
            int readyCount = selector.select();

            if (readyCount == 0) continue;

            // 5. 获取就绪的事件
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();  // 必须手动移除

                if (key.isAcceptable()) {
                    // 6. 处理新连接
                    handleAccept(key, selector);
                } else if (key.isReadable()) {
                    // 7. 处理读事件
                    handleRead(key, buffer);
                }
            }
        }
    }

    private static void handleAccept(SelectionKey key, Selector selector)
            throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);

        // 注册读事件
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Client connected: " + clientChannel.getRemoteAddress());
    }

    private static void handleRead(SelectionKey key, ByteBuffer buffer)
            throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        buffer.clear();

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
            System.out.println("Client disconnected: " + channel.getRemoteAddress());
            key.cancel();
            channel.close();
        }
    }
}
