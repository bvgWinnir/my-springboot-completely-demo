package com.bvgol.example.activemq.controller;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@AllArgsConstructor
public class Producer {
    private JmsMessagingTemplate jmsTemplate;

    private Queue queue;

    private Topic topic;

    //发送queue类型消息
    @GetMapping("/queue")
    public void sendQueueMsg(String msg) {
        jmsTemplate.convertAndSend(queue, msg);
    }

    //发送topic类型消息
    @GetMapping("/topic")
    public void sendTopicMsg(String msg) {
        jmsTemplate.convertAndSend(topic, msg);
    }

}
