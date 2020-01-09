package com.MyNetty.myTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyNettyClientInHandler extends ChannelInboundHandlerAdapter{
    public MyNettyClientInHandler() {
        super();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:channelUnregistered");

        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:channelActive");

        new Thread(){

            @Override
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                    String line = "";
                    ByteBuf byteBuf = Unpooled.buffer(1024);

                    while ((line = bufferedReader.readLine()) != null){

                        byteBuf = byteBuf.retain().duplicate();
                        byteBuf.writeBytes(line.getBytes());
                        ctx.writeAndFlush(byteBuf);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:channelInactive");

        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("MyNettyClientInHandler:channelRead");

        ByteBuf byteBuf = (ByteBuf) msg;

        byte[] bytes = new byte[byteBuf.readableBytes()];

        byteBuf.readBytes(bytes);


        System.out.println("netty客户端收到的信息："+new String(bytes,"UTF-8"));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:channelReadComplete");

        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("MyNettyClientInHandler:userEventTriggered");

        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:channelWritabilityChanged");

        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("MyNettyClientInHandler:exceptionCaught");

        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println("MyNettyClientInHandler:ensureNotSharable");

        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("MyNettyClientInHandler:isSharable");

        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:handlerAdded");

        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientInHandler:handlerRemoved");

        super.handlerRemoved(ctx);
    }
}
