package com.spring.securityPractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "Hello2";
    }

    @GetMapping("/hello/world")
    public String hello3(){
        return "Hello World";
    }
    @GetMapping("/scores")
    public String publicScore(){
        return "Highest Score is 900";
    }

    @GetMapping("/personal/score")
    public String score(){
        return "Your personal score is ";
    }

    @GetMapping("/public/info")
    public String publicInfo(){
        return "Every role will show this";
    }


}
