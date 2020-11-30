package com.janson653.mytomcat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTomcatApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyTomcatApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("我是tomcat仿真,准备启动了");
    }
}
