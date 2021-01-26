package com.janson653.nettydemo.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 * @author zhangqian
 * @date 2021/1/26
 */
@Slf4j
public class MyEchoServerHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("read msg={}", byteBuf.toString(StandardCharsets.UTF_8));

        ByteBuf resp = Unpooled.wrappedBuffer("pong".getBytes());
        ctx.writeAndFlush(resp);
    }
}
