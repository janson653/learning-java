package com.janson653.mytomcat.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyHttpResponse {
    public static final int BUFFER_SIZE = 2048;
    // 浏览器默认访问 download内容
    private static final String WEB_ROOT = "C:\\Users\\janson\\Downloads";
    private MyHttpRequest request;
    private OutputStream output;

    public MyHttpResponse(OutputStream output) {
        this.output = output;
    }

    public void setRequest(MyHttpRequest request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        // 开始转换
        request.parse();
        System.out.println("请求url" + request.getURL());

        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(WEB_ROOT, request.getURL());

            if (file.exists() && !file.isDirectory()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                String header = "HTTP/1.1 200 \r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n";

                output.write(header.getBytes());
                while (ch != -1) {
                    output.write(bytes, 0, ch);// 写回浏览器
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                String html = "<h1>file not exit</h1>";
                String header = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " + html.length() + "\r\n"
                        + "\r\n" + html;
                output.write(header.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            String html = "<h1>file not exit</h1>";
            String header = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + html.length() + "\r\n"
                    + "\r\n" + html;
            output.write(header.getBytes());
        }
        finally {
            output.flush();
            if(fis != null) {
                fis.close();
            }
        }

    }

}
