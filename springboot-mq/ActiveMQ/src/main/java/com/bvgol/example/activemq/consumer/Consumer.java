package com.bvgol.example.activemq.consumer;/**
 * @Classname Consumer
 * @Description TODO
 * @Date 2021/1/8 16:07
 * @Created by GUOCHEN
 */

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @program: my-springboot-completely
 * @description: consumer
 * @author: GUOCHEN
 * @create: 2021/01/08 16:07
 */
@Component
public class Consumer {

    //接收queue类型消息
    //destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
    @JmsListener(destination = "springboot.queue")
    public void ListenQueue(String msg) {
        System.out.println("接收到queue消息：" + msg);
    }

    //接收topic类型消息
    //destination对应配置类中ActiveMQTopic("springboot.topic")设置的名字
    //containerFactory对应配置类中注册JmsListenerContainerFactory的bean名称
    @JmsListener(destination = "springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void ListenTopic(String msg) {
        System.out.println("接收到topic消息：" + msg);
    }
}
