package com.MyNetty.myTest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

public class MyNettyServiceSocket {

    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public void start() throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        EventLoopGroup group = new NioEventLoopGroup();


        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.option(ChannelOption.SO_BACKLOG, 1024);
            sb.group(group, bossGroup) // 绑定线程池
                    .channel(NioServerSocketChannel.class) // 指定使用的channel
                    .localAddress(this.port)// 绑定监听端口
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("报告");
                            System.out.println("信息：有一客户端链接到本服务端");
                            System.out.println("IP:" + ch.localAddress().getHostName());
                            System.out.println("Port:" + ch.localAddress().getPort());
                            System.out.println("报告完毕");

                            ch.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
                            ch.pipeline().addLast(new MyNettyServiceHandler()); // 客户端触发操作
                            ch.pipeline().addLast(new ByteArrayEncoder());
                        }
                    });
            ChannelFuture cf = sb.bind().sync(); // 服务器异步创建绑定
            System.out.println(MyNettyServiceSocket.class + " 启动正在监听： " + cf.channel().localAddress());
            cf.channel().closeFuture().sync(); // 关闭服务器通道
        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
            bossGroup.shutdownGracefully().sync();
        }
    }



    public static void main(String[] args) throws Exception{
     /*   // 创建mainReactor

        NioEventLoopGroup boosGroup = new NioEventLoopGroup();

        // 创建工作线程组

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap

                // 组装NioEventLoopGroup

                .group(boosGroup, workerGroup)

                // 设置channel类型为NIO类型

                .channel(NioServerSocketChannel.class)

                // 设置连接配置参数

                .option(ChannelOption.SO_BACKLOG, 1024)

                .childOption(ChannelOption.SO_KEEPALIVE, true)

                .childOption(ChannelOption.TCP_NODELAY, true)

                // 配置入站、出站事件handler

                .childHandler(new ChannelInitializer<NioSocketChannel>() {

                    @Override
                    protected void initChannel(NioSocketChannel ch) {

                 // 配置入站、出站事件channel

                 // ch.pipeline().addLast(...);

                 // ch.pipeline().addLast(...);

                }

        });



        // 绑定端口

        int port = 8886;

        serverBootstrap.bind(port).addListener(future -> {

            if(future.isSuccess()) {

                System.out.println(new Date() + ": 端口["+ port + "]绑定成功!");

            }else{

                System.err.println("端口["+ port + "]绑定失败!");

            }

        });*/

        MyNettyServiceSocket serviceSocket = new MyNettyServiceSocket();
        serviceSocket.setPort(8889);
        serviceSocket.start();
    }
}
