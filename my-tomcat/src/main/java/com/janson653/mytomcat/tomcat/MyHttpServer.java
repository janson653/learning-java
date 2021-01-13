package com.janson653.mytomcat.tomcat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHttpServer {
    private volatile boolean shutdown = false;

    public void acceptWait() {
        System.out.println("等待接听");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080,1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // 启动没问题,开始等待输入
        System.out.println("启动没问题,开始等待输入");
        while (!shutdown) {
            try {
                Socket socket = serverSocket.accept();
                // 接受请求参数
                MyHttpRequest myHttpRequest = new MyHttpRequest(socket.getInputStream());
                MyHttpResponse myHttpResponse = new MyHttpResponse(socket.getOutputStream());
                myHttpResponse.setRequest(myHttpRequest);

                // response根据请求,寻找对应文件
                myHttpResponse.sendStaticResource();

                // 关闭一次socket
                socket.close();

                if(null != myHttpRequest) {
                    shutdown = myHttpRequest.getURL().equals("/shutdown");
                }

            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("启动tomcat, 开始监听80端口");
        MyHttpServer myHttpServer = new MyHttpServer();
        myHttpServer.acceptWait();
    }
}
