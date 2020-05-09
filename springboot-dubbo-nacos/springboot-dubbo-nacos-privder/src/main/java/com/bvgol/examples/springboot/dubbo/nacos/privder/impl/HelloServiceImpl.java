package com.bvgol.examples.springboot.dubbo.nacos.privder.impl;

import com.bvgol.examples.springboot.dubbo.nacos.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.util.UUID;

/**
 * @Classname HelloServiceImpl
 * @Description TODO
 * @Date 2020/5/9 11:21
 * @Created by guochen
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String str) {
        return str+"--"+ UUID.randomUUID().toString();
    }
}
