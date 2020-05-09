package com.bvgol.examples.dubbo.zk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bvgol.examples.dubbo.zk.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2020/5/9 10:34
 * @Created by guochen
 */
@Slf4j
@RestController
@RequestMapping("dubbo/test")
public class HelloController {
    //这个注解
    @Reference
    private HelloService helloService;

    @GetMapping("/testDubbo")
    public Object testDubbo(){
        return helloService.testDubbo();
    }
}
