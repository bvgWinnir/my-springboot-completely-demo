package com.bvgol.examples.springbootredis.com.config;

/**
 * @program: my-springboot-completely
 * @description: 防刷配置类
 * @author: GUOCHEN
 * @create: 2020/12/08 09:12
 */

import com.bvgol.examples.springbootredis.com.interceptor.FangshuaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yhq
 * @date 2018/9/10 15:58
 */

@Configuration

public class FangShuaConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private FangshuaInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor);

    }

}
