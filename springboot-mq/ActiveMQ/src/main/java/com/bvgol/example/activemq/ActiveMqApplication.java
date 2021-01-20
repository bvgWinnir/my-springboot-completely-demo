package com.bvgol.example.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: my-springboot-completely
 * @description: 启动类
 * @author: GUOCHEN
 * @create: 2021/01/06 13:44
 */
@SpringBootApplication
//如果不添加额外的扫描注解， 则本启动类只会扫描到该本包下的文件， 不会扫到引入项目的文件
//@EntityScan("com.xuecheng.framework.domain.cms")//扫描实体类（扫描带有@Entity的实体类）
//@ComponentScan(basePackages={"com.xuecheng.api"})//扫描接口（扫描带有@Component以及子注解的类）
//@ComponentScan(basePackages={"com.xuecheng.framework"})//扫描common包（扫描带有@Component以及子注解的类）
//@ComponentScan(basePackages={"com.xuecheng.manage_cms"})//扫描本项目下的所有类（不添加也可以）
public class ActiveMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveMqApplication.class, args);

    }

}
