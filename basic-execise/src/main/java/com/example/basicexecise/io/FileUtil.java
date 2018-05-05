package com.example.basicexecise.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        newIOCopy3("/tmp/win7.iso", "/tmp/win72.iso");
        //oldIOCopy("/tmp/win7.iso", "/tmp/win72.iso");
        long cost = System.currentTimeMillis() - start;
        System.out.println("cost: " + cost / 1000 + "s");
    }

    public static void oldIOCopy(String name, String copy) throws IOException {
        InputStream in = new FileInputStream(new File(name));
        OutputStream out = new FileOutputStream(new File(copy));

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }

        out.close();
        in.close();
    }

    public static void newIOCopy(String name, String copy) {
        try {
            FileChannel in = new FileInputStream(new File(name)).getChannel();
            FileChannel out = new FileOutputStream(new File(copy)).getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 );

            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
            out.close();
            in.close();

        } catch (Exception e) {
        } finally {
        }
    }

    public static void newIOCopy2(String name, String copy) {
        try {
            FileChannel in = new FileInputStream(new File(name)).getChannel();
            FileChannel out = new FileOutputStream(new File(copy)).getChannel();

            out.transferFrom(in, 0, in.size());
            out.close();
            in.close();

        } catch (Exception e) {
        } finally {
        }
    }

    public static void newIOCopy3(String name, String copy) {
        try {
            FileChannel in = new FileInputStream(new File(name)).getChannel();
            FileChannel out = new FileOutputStream(new File(copy)).getChannel();

            MappedByteBuffer buffer = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());

            out.write(buffer);
            buffer.force();



            System.out.println("copy done");

            out.close();
            in.close();

        } catch (Exception e) {
        } finally {
        }
    }
}
