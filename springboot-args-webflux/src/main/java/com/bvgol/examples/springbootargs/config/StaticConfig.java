package com.bvgol.examples.springbootargs.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname StaticConfig
 * @Description TODO
 * @Date 2020/5/3 16:52
 * @Created by guochen
 */
@Slf4j
@Configuration
public class StaticConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    //http://localhost:9999/static/ic_btn_logout.png

}
