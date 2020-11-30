package com.janson653.basicexecise.aop.aspecj;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void sayHello() {
        System.out.println("userService sayHello");
    }
}
