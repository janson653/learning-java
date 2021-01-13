package com.janson653.nettydemo.simple;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MultiClient {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                try {
                    long start = System.currentTimeMillis();
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(9999));

                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("ping".getBytes());
                    outputStream.flush();

//
//                    InputStream inputStream = socket.getInputStream();
//                    byte[] bytes = inputStream.readAllBytes();
//                    String resp = new String(bytes);

                    socket.close();
                    long cost = System.currentTimeMillis() - start;
                    System.err.println("cost:" + cost + ", resp=" );
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
