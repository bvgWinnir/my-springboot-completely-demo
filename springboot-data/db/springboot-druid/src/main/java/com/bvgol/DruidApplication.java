
package com.bvgol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname DruidApplication
 * @Description TODO
 * @Date 2020/9/8 15:40
 * @Created by GUOCHEN
 */
@SpringBootApplication
public class DruidApplication {
    public static void main(String[] args) {
        SpringApplication.run(DruidApplication.class, args);
    }

//    http://localhost:8080/druid/login.html
    /**
     * 通过 resttool 执行sql 后
     * web console plant sql
     * 但是重启服务会清空之前的
     */
}
