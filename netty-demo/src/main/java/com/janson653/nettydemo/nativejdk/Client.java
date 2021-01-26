package com.janson653.nettydemo.nativejdk;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            long start = System.currentTimeMillis();
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(9999));

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("ping".getBytes());
            outputStream.flush();

            socket.close();
            long cost = System.currentTimeMillis() - start;
            System.err.println("cost:" + cost + ", resp=");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
