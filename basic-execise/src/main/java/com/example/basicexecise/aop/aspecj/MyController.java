package com.example.basicexecise.aop.aspecj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println(userService.getClass());
        userService.sayHello();
        return "hello";
    }
}
