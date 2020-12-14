package com.bvgole.examples.rocket.producer.config;

/**
 * @Classname rocketmq
 * @Description TODO
 * @Date 2020/11/18 10:54
 * @Created by GUOCHEN
 * @program: my-springboot-completely
 * @description: config
 * @author: GUOCHEN
 * @create: 2020/11/18 10:54
 */

/**
 * @program: my-springboot-completely
 * @description: config
 * @author: GUOCHEN
 * @create: 2020/11/18 10:54
 */

import lombok.Data;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lockie
 * @Date: 2020/4/21 10:28
 * @Description: mq生产者配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
public class MQProducerConfigure {
    public static final Logger LOGGER = LoggerFactory.getLogger(MQProducerConfigure.class);

    private String groupName;
    private String namesrvAddr;
    /**消息最大值 */
    private Integer maxMessageSize;
    /**消息发送超时时间 */
    private Integer sendMsgTimeOut;
    /** 失败重试次数 */
    private Integer retryTimesWhenSendFailed;

    /**
     * mq 生成者配置
     * @return
     * @throws MQClientException
     */
    @Bean
    @ConditionalOnProperty(prefix = "rocketmq.producer", value = "isOnOff", havingValue = "on")
    public DefaultMQProducer defaultProducer() throws MQClientException {
        LOGGER.info("defaultProducer 正在创建---------------------------------------");
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setSendMsgTimeout(sendMsgTimeOut);
        producer.setRetryTimesWhenSendAsyncFailed(retryTimesWhenSendFailed);
        producer.start();
        LOGGER.info("rocketmq producer server 开启成功----------------------------------");
        return producer;
    }
}
