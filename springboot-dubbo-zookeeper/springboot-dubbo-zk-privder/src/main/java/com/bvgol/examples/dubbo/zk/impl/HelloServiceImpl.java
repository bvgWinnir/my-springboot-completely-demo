package com.bvgol.examples.dubbo.zk.impl;

import com.bvgol.examples.dubbo.zk.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.UUID;

/**
 * @Classname ServiceImpl
 * @Description TODO
 * @Date 2020/5/9 10:35
 * @Created by guochen
 */
@Slf4j
@Service //这个注解
public class HelloServiceImpl implements HelloService {
    @Override
    public String testDubbo(){
        return this.getClass().getTypeName()+ UUID.randomUUID().toString();
    }
}
