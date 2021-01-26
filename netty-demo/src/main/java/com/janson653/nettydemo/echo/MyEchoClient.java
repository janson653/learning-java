package com.janson653.nettydemo.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.util.concurrent.DefaultThreadFactory;

import javax.net.ssl.SSLException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangqian
 * @date 2021/1/26
 */
public class MyEchoClient {
    static final boolean SSL = System.getProperty("ssl") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) throws CertificateException, SSLException {
        final SslContext sslContext;
        if (SSL) {
            SelfSignedCertificate selfSignedCertificate = new SelfSignedCertificate();
            sslContext = SslContextBuilder.forServer(selfSignedCertificate.certificate(), selfSignedCertificate.privateKey()).build();
        } else {
            sslContext = null;
        }

        EventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("boss"));
        LoggingHandler loggingHandler = new LoggingHandler(LogLevel.INFO);
        MyEchoClientHandler myEchoClientHandler = new MyEchoClientHandler();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup)
                    .handler(loggingHandler)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            if (sslContext != null) {
                                ch.pipeline().addLast(sslContext.newHandler(ch.alloc()));
                            }
                            ch.pipeline().addLast(loggingHandler);
                            ch.pipeline().addLast(myEchoClientHandler);
                        }
                    });

            ChannelFuture f = bootstrap.connect("127.0.0.1", PORT).sync();

            ChannelFuture sync = f.channel().writeAndFlush(Unpooled.wrappedBuffer("ping".getBytes(StandardCharsets.UTF_8))).sync();



            // wait to close
            f.channel().closeFuture().sync();
        } catch (InterruptedException  e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }
}
