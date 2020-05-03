package com.bvgol.examples.springbootargs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

/**
 * @Classname SessionController
 * @Description TODO
 * @Date 2020/4/27 11:59
 * @Created by guochen
 */
@Slf4j
@RestController("/session")
public class SessionController {

    @GetMapping("/login")
    public Object login(@RequestBody Map map){
        return UUID.randomUUID().toString()+"--"+map.toString();
    }

    @GetMapping("/handle")
    public Object handle(@RequestBody Map map){
        return UUID.randomUUID().toString()+"--"+map.toString();
    }
    @GetMapping("/testFilter")
    public Object testFilter(){
        return UUID.randomUUID().toString();
    }

}
