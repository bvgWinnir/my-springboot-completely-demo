package com.bvgol.example.activemq.logic;

/**
 * @author <a href="mailto:avaos.wei@gmail.com">avaos.wei</a>
 * @title 新闻发布
 * @Desc
 * @Date 2020-03-27 16:52
 */
public interface NewsProducerService {

    /**
     * @param msg: 待发布的内容
     * @return
     * @title 发布消息
     * @desc 描述
     * @author <a href="mailto:avaos.wei@gmail.com">avaos.wei</a>
     * @date 2020-03-27 16:52
     */
    void publish(String msg);

}
