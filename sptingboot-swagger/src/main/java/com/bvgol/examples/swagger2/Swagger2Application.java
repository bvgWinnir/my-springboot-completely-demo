package com.bvgol.examples.swagger2;


import io.swagger.annotations.SwaggerDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname Swagger2Application
 * @Description TODO
 * @Date 2020/5/27 16:41
 * @Created by guochen
 */
@SwaggerDefinition
@SpringBootApplication
public class Swagger2Application {
        public static void main(String[] args) {
            SpringApplication.run(Swagger2Application.class, args);
        }
}
