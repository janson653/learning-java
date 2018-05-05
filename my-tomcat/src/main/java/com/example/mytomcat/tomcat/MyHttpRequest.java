package com.example.mytomcat.tomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyHttpRequest {
    private InputStream is;
    private String url;

    public MyHttpRequest(InputStream input) {
        this.is = input;
    }

    /**
     * 由input转换为url
     */
    public void parse() {
        // todo
        StringBuffer request = new StringBuffer(MyHttpResponse.BUFFER_SIZE);
        int i;
        byte[] buffer = new byte[MyHttpResponse.BUFFER_SIZE];
        try {
            i = is.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }

        // 装换byte到char,这样才能可读
        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
        System.out.println(request.toString());
        url = parseUrl(request.toString());
    }

    public String getURL() {
        return this.url;
    }

    private String parseUrl(String requestStr) {
        int index1, index2 = 0;
        index1 = requestStr.indexOf(" "); //看socket是否有值
        if (index1 != -1) {
            index2 = requestStr.indexOf(" ", index1 + 1);
            if(index2 > index1) {
                return requestStr.substring(index1 + 1, index2);
            }
        }
        return null;
    }
}
