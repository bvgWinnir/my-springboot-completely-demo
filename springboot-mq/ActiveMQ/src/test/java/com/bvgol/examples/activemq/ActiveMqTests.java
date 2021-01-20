package com.bvgol.examples.activemq;

import com.example.demoactivemq.domain.MessageModel;
import com.example.demoactivemq.producer.Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoActivemqApplication.class)
@RunWith(SpringRunner.class)
class DemoActivemqApplicationTests {

    /**
     * 消息生产者
     */
    @Autowired
    private Producer producer;

    /**
     * 及时消息队列测试
     */
    @Test
    public void test() {
        MessageModel messageModel = MessageModel.builder()
                .message("测试消息")
                .titile("消息000")
                .build();
        // 发送消息
        producer.send(Producer.DEFAULT_QUEUE, messageModel);
    }

    /**
     * 延时消息队列测试
     */
    @Test
    public void test2() {
        for (int i = 0; i < 5; i++) {
            MessageModel messageModel = MessageModel.builder()
                    .titile("延迟10秒执行")
                    .message("测试消息" + i)
                    .build();
            // 发送延迟消息
            producer.delaySend(Producer.DEFAULT_QUEUE, messageModel, 10000L);
        }
        try {
            // 休眠100秒，等等消息执行
            Thread.currentThread().sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
