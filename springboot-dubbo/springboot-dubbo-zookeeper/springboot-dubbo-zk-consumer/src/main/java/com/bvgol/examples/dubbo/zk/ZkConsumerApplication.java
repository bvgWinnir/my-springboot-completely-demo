package com.bvgol.examples.dubbo.zk;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname ZkConsumerApplication
 * @Description TODO
 * @Date 2020/5/9 10:43
 * @Created by guochen
 */
@Slf4j
@SpringBootApplication
@EnableDubbo //这个注解
public class ZkConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkConsumerApplication.class, args);
    }
}
