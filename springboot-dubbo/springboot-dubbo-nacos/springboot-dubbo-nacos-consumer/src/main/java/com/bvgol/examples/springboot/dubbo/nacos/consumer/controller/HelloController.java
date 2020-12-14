package com.bvgol.examples.springboot.dubbo.nacos.consumer.controller;

import com.bvgol.examples.springboot.dubbo.nacos.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2020/5/9 11:23
 * @Created by guochen
 */
@Slf4j
@RestController
@RequestMapping("/nacos")
public class HelloController {
    @Reference
    private HelloService helloService;

    @GetMapping("testDubbo.json/{str}")
    public Object testDubbo(@RequestParam("str") String str){
        return helloService.sayHello(str);
    }
}
