package com.bvgol.example.activemq.controller;

import com.bvgol.example.activemq.logic.NewsProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsProducerService newsProducerService;

    @GetMapping
    public Object produce(String msg) {
        newsProducerService.publish(msg);
        log.info("-------------------------------------------------------------------------");
        log.info("produce: 发布消息-{}", msg);
        log.info("-------------------------------------------------------------------------");

        return "success";
    }
}
