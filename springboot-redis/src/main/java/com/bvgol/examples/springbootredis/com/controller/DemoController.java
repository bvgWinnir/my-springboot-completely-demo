package com.bvgol.examples.springbootredis.com.controller;

import com.bvgol.examples.springbootredis.com.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api")
public class DemoController {
    @GetMapping("info")
    @Cacheable(cacheNames = "demo-info", key = "#name")
    public R<String> info(String name) {
        log.info("本条信息没有从缓存获取");
        return R.data("Hello, My Name Is: " + name);
    }

    @GetMapping("remove-info")
    @CacheEvict(cacheNames = "demo-info", key = "#name")
    public R<String> removeInfo(String name) {
        return R.success("删除缓存成功");
    }
}