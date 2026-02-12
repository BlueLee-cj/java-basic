package com.example.lcj.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Netty 服务端示例
 * 
 * 核心概念：
 * 1. EventLoopGroup - 线程池，内部使用 IO 多路复用
 * 2. Channel - 网络连接通道
 * 3. ChannelHandler - 处理网络事件的处理器
 * 4. ChannelPipeline - 处理器链，像流水线一样处理数据
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        // ==================== 核心组件 ====================
        
        // bossGroup: 负责接收新连接（相当于 NIO 的 OP_ACCEPT）
        // 通常1个线程就够了
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        
        // workerGroup: 负责处理已连接的 IO 读写（相当于 NIO 的 OP_READ/OP_WRITE）
        // 默认 CPU核心数 * 2 个线程，每个线程内部用 Selector 管理多个连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // ServerBootstrap: 服务端启动引导类，简化配置
            ServerBootstrap bootstrap = new ServerBootstrap();
            
            bootstrap
                // 设置线程组
                .group(bossGroup, workerGroup)
                // 指定使用 NIO 模式（底层用 Selector 实现 IO 多路复用）
                .channel(NioServerSocketChannel.class)
                // 设置连接队列大小
                .option(ChannelOption.SO_BACKLOG, 128)
                // 保持长连接
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 配置处理器链
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline pipeline = ch.pipeline();
                        
                        // 添加解码器：ByteBuf -> String
                        pipeline.addLast("decoder", new StringDecoder());
                        // 添加编码器：String -> ByteBuf
                        pipeline.addLast("encoder", new StringEncoder());
                        // 添加业务处理器
                        pipeline.addLast("handler", new ServerHandler());
                    }
                });

            System.out.println("Netty Server 启动中...");
            
            // 绑定端口，同步等待启动完成
            ChannelFuture future = bootstrap.bind(8080).sync();
            System.out.println("Netty Server 启动成功，监听端口: 8080");

            // 等待服务端关闭
            future.channel().closeFuture().sync();
            
        } finally {
            // 优雅关闭线程池
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

/**
 * 业务处理器
 * 继承 SimpleChannelInboundHandler，自动释放消息
 */
class ServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 客户端连接时触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接: " + ctx.channel().remoteAddress());
    }

    /**
     * 收到客户端消息时触发
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        System.out.println("收到消息: " + msg);
        
        // 回复客户端
        String response = "服务端收到: " + msg;
        ctx.writeAndFlush(response);
    }

    /**
     * 客户端断开连接时触发
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端断开: " + ctx.channel().remoteAddress());
    }

    /**
     * 发生异常时触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
