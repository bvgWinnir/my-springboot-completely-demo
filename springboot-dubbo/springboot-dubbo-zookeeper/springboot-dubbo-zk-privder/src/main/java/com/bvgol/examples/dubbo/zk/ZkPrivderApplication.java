package com.bvgol.examples.dubbo.zk;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname ZkPrivderApplication
 * @Description TODO
 * @Date 2020/5/9 10:42
 * @Created by guochen
 */
@EnableDubbo
@SpringBootApplication
public class ZkPrivderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkPrivderApplication.class, args);
    }
}
