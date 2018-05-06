package com.example.basicexecise.springresource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringResourceTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testResource() throws IOException {
        Resource resource = applicationContext.getResource("classpath://test.txt");
        System.out.println(resource.getFilename());

        // todo
        Resource httpResource = applicationContext.getResource("http://baidu.com");
    }
}
