package com.bvgol.devtools.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("helloGradle")
public class HelloController {

    @GetMapping("hi")
    public Object hi(){
        return LocalDateTime.now()+"--"+LocalTime.now();
    }

    @GetMapping("hi2")
    public Object hi2(){
        return LocalDateTime.now();
    }

    @GetMapping("hi3")
    public Object hi3(){
        return LocalDateTime.now();
    }
}
