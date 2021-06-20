package com.study.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("http:www.baidu.com")
public class TestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "你好吗";
    }
}
