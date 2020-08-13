package com.bvgol.examples.springbootLogback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2721:26
 */
@SpringBootApplication
public class LogbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }

    private Logger log = LoggerFactory.getLogger(LogbackApplication.class);

    @Bean
    public void info(){
        log.info("info"+ LocalDateTime.now());
    }

    @Bean
    public void debug(){
        log.debug("debug"+ LocalDateTime.now());
    }
    @Bean
    public void warn(){
        log.warn("warn"+ LocalDateTime.now());
    }

    @Bean
    public void error(){
        try {
            int a =1/0;
        }
        catch (Exception e){

            log.error("error",e);
        }
    }
}
