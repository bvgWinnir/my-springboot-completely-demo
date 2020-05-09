package com.bvgol.examples.springboot.dubbo.nacos.privder;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class NacosPrivderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosPrivderApplication.class, args);
    }

}