package com.bvgol.examples.dubbo.zk.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bvgol.examples.dubbo.zk.api.Hello2Service;
import com.bvgol.examples.dubbo.zk.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author GUOCHEN
 * @Classname ServiceImpl
 * @Description TODO
 * @Date 2020/5/9 10:35
 * @Created by guochen
 */
@Slf4j
@Service //这个注解
public class Hello2ServiceImpl implements Hello2Service {
    @Reference
    private HelloService helloService;
    @Override
    public String testDubbo(){
        return this.getClass().getTypeName()+ UUID.randomUUID().toString();
    }

    @Override
    public String testDubbo2() {
        return helloService.testDubbo();
    }
}
