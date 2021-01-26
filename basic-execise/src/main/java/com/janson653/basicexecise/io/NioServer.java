package com.janson653.basicexecise.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        serverSocket.bind(address);

        while (true) {
//            System.out.println(Thread.currentThread().getId() + ", before select");
            int nums = selector.selectNow();
//            System.out.println(Thread.currentThread().getId() + ", after select");

            if (nums <=0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                    SocketChannel accept = ssChannel1.accept();
                    accept.configureBlocking(false);

                    accept.register(selector, SelectionKey.OP_READ);
                }
                //
                else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    // read data
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    StringBuilder accum = new StringBuilder();
                    while (socketChannel.read(buffer) != -1) {
                        buffer.flip();

                        for(int i = 0 ; i < buffer.limit(); i++) {
                            accum.append((char) buffer.get(i));
                        }
                        buffer.clear();
                    }
                    System.out.println(accum.toString());

                    socketChannel.close();
                }

                iterator.remove();
            }
        }

    }
}
