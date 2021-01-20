//package com.bvgol.example.activemq.producer;/**
// * @Classname Producer
// * @Description TODO
// * @Date 2021/1/8 16:06
// * @Created by GUOCHEN
// */
//
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.jms.Queue;
//
///**
// * @program: my-springboot-completely
// * @description: produce
// * @author: GUOCHEN
// * @create: 2021/01/08 16:06
// */
//@Component
//public class Producer {
//    @Resource
//    private JmsMessagingTemplate jmsMessagingTemplate;
//    @Resource
//    private Queue queue;
//    public void sendMsg(String msg) {
//        System.out.println("发送消息内容 :" + msg);
//        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
//    }}
