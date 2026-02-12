package com.example.lcj.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * Netty 客户端示例
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
       start();
    }

    public static void start()throws InterruptedException {
        // 客户端只需要一个 EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // Bootstrap: 客户端启动引导类
            Bootstrap bootstrap = new Bootstrap();

            bootstrap
                    .group(group)
                    // 客户端使用 NioSocketChannel
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("handler", new ClientHandler());
                        }
                    });

            // 连接服务端
            ChannelFuture future = bootstrap.connect("localhost", 8080).sync();
            System.out.println("连接服务端成功!");

            Channel channel = future.channel();

            // 从控制台读取输入并发送
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入消息（输入 quit 退出）:");

            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                if ("quit".equalsIgnoreCase(msg)) {
                    break;
                }
                // 发送消息到服务端
                channel.writeAndFlush(msg);
            }

            channel.closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}

/**
 * 客户端处理器
 */
class ClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("已连接到服务端: " + ctx.channel().remoteAddress());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        System.out.println("收到服务端响应: " + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
