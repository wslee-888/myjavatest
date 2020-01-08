package com.MyNetty.myTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyNettyServerInHandler extends ChannelInboundHandlerAdapter {
    public MyNettyServerInHandler() {
        super();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:channelUnregistered");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:channelActive");

        //super.channelActive(ctx);

        new Thread(){

            @Override
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                    String line = "";
                    while ((line = bufferedReader.readLine()) != null){
                        ctx.writeAndFlush(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("MyNettyServerInHandler:channelRead");
        //System.out.println(msg);
        //ctx.writeAndFlush(msg);

        ByteBuf byteBuf = (ByteBuf) msg;

        byte[] bytes = new byte[byteBuf.readableBytes()];

        byteBuf.readBytes(bytes);


        System.out.println("netty服务端收到的信息："+new String(bytes,"UTF-8"));


        //NioSocketChannel nioSocketChannel = (NioSocketChannel) ctx.channel();


        //super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:channelReadComplete");

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();
        //while ((line = bufferedReader.readLine()) != null){
            ctx.writeAndFlush(line);
        //}*/

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("MyNettyServerInHandler:userEventTriggered");

        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:channelWritabilityChanged");

        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("MyNettyServerInHandler:exceptionCaught");

        super.exceptionCaught(ctx, cause);

    }

    @Override
    protected void ensureNotSharable() {
        System.out.println("MyNettyServerInHandler:ensureNotSharable");

        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("MyNettyServerInHandler:isSharable");

        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:handlerAdded");

        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyServerInHandler:handlerRemoved");

        super.handlerRemoved(ctx);
    }
}
