package com.bvgol.example.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TopicConsumer {

    @JmsListener(destination = "news.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void receive1(String msg) {
        log.info("{} 接收到消息: {}", "1号", msg);
    }

    @JmsListener(destination = "news.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void receive2(String msg) {
        log.info("{} 接收到消息: {}", "2号", msg);
    }

    @JmsListener(destination = "news.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void receive3(String msg) {
        log.info("{} 接收到消息: {}", "3号", msg);
    }

    @JmsListener(destination = "news.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void receive4(String msg) {
        log.info("{} 接收到消息: {}", "4号", msg);
    }

}
