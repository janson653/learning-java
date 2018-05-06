package com.example.basicexecise.aop.aspecj;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void sayHello() {
        System.out.println("userService sayHello");
    }
}
