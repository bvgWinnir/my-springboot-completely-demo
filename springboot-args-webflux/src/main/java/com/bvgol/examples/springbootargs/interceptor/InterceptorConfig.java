package com.bvgol.examples.springbootargs.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/login").excludePathPatterns("/login", "session/login", "/postMap");
        registry.addInterceptor(new DuplicationInterceptor());
//        this.addInterceptors(registry);
    }
}