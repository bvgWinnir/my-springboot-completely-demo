package com.bvgol.examples.springbootSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2811:05
 */
@EnableRedisHttpSession
@SpringBootApplication
public class SpringbootSessionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSessionApplication.class, args);
    }
}
