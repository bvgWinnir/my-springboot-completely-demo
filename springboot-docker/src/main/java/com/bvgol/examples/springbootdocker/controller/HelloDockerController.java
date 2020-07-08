package com.bvgol.examples.springbootdocker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController("/helloDocker")
public class HelloDockerController {

    @Value("${server.port)")
    private String port;

    @GetMapping("/get/{str}")
    public String get (@PathVariable("str") String str){
        return port+"----"+str+ LocalDateTime.now();
    }
}
