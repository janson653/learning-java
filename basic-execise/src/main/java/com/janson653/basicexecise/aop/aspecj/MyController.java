package com.janson653.basicexecise.aop.aspecj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {
    @Autowired
    UserService userService;
    ResponseBodyEmitter emitter;

    @GetMapping("/hello")
    public String sayHello(Principal principal,
                           HttpMethod method) {

        System.out.println(userService.getClass());
        userService.sayHello();
        return "hello";
    }

    @GetMapping("/hello2")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> sayHello2() throws InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("name", "zhangqian");
        Thread.sleep(10000L);
        return new ResponseEntity<Map<String, Object>>(body, HttpStatus.OK);
    }

    @GetMapping("/quotes")
    @ResponseBody
    public DeferredResult<String> quotes(HttpServletRequest request) throws InterruptedException {
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        // Save the deferredResult somewhere..
        new Thread(() -> {

            deferredResult.setResult("zhangqian");

        }).start();
        return deferredResult;
    }

    @GetMapping("/events")
    public ResponseBodyEmitter handle() {
        emitter = new ResponseBodyEmitter();
        return emitter;
    }

    @GetMapping("/triggerEvent")
    public void triggerEvent() throws IOException {
        // Save the emitter somewhere..
        emitter.send("Hello once");

// and again later on
        emitter.send("Hello again");
    }
}
