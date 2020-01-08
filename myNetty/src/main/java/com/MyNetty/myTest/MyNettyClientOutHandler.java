package com.MyNetty.myTest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

import java.net.SocketAddress;

public class MyNettyClientOutHandler extends ChannelOutboundHandlerAdapter{
    public MyNettyClientOutHandler() {
        super();
    }

    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println("MyNettyClientOutHandler:bind");

        super.bind(ctx, localAddress, promise);
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println("MyNettyClientOutHandler:connect");

        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println("MyNettyClientOutHandler:disconnect");

        super.disconnect(ctx, promise);
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println("MyNettyClientOutHandler:close");

        super.close(ctx, promise);
    }

    @Override
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println("MyNettyClientOutHandler:deregister");

        super.deregister(ctx, promise);
    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientOutHandler:read");

        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("MyNettyClientOutHandler:write");

        super.write(ctx, msg, promise);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientOutHandler:flush");

        super.flush(ctx);
    }

    @Override
    protected void ensureNotSharable() {
        System.out.println("MyNettyClientOutHandler:ensureNotSharable");

        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        System.out.println("MyNettyClientOutHandler:isSharable");

        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientOutHandler:handlerAdded");

        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyNettyClientOutHandler:handlerRemoved");

        super.handlerRemoved(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("MyNettyClientOutHandler:exceptionCaught");

        super.exceptionCaught(ctx, cause);
    }
}
