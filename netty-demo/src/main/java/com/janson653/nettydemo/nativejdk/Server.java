package com.janson653.nettydemo.nativejdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Thread ioschedule = new Thread(new IOSchedule().setSocket(serverSocket));
        ioschedule.start();
    }

    static class IOSchedule implements Runnable {
        ServerSocket socket = null;

        public IOSchedule setSocket(ServerSocket socket) {
            this.socket = socket;
            return this;
        }

        @Override
        public void run() {
            System.err.println("server started");
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getState() + ", before accept");

                    Socket accept = socket.accept();
                    System.out.println(Thread.currentThread().getState() + ", after accept");

                    InputStream inputStream = accept.getInputStream();
                    byte[] bytes = inputStream.readAllBytes();

                    System.out.println("receive req: " + new String(bytes));
                    OutputStream outputStream = accept.getOutputStream();
                    outputStream.write("pong".getBytes());
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Work implements Runnable {

        @Override
        public void run() {

        }
    }

}
