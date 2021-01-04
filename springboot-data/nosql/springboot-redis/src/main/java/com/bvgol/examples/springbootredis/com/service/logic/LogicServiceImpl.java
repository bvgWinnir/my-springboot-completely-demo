package com.bvgol.examples.springbootredis.com.service.logic;/**
 * @Classname LogicServiceImpl
 * @Description TODO
 * @Date 2021/1/4 14:05
 * @Created by GUOCHEN
 */

import com.bvgol.examples.springbootredis.com.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2021/01/04 14:05
 */
@Service
@AllArgsConstructor
public class LogicServiceImpl implements LogicService {
    private RedisTemplate redisTemplate;

    private static final String TOKEN_PREFIX = "order:token:";

    @Override
    public Book logic(Integer token) throws Exception {
        /**
         * 此种实现完整描述(交互式)
         * 在生成这个数据对象的时候
         *      生成一个唯一标志，防止重复提交（响应到页面有一份，有一份保存到redis中）
         * 使用(提交/更新)时
         *      查询redis中有没有token信息, 有，则是第一次提交，放行并删除redis中的orderToken
         *      没有,不合规的数据`返回
         *★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
         *★★★★特别注意`这种方式 实现简单`但是需要结合业务上下文★★★★
         *★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
         * @date: 2021/1/4 15:09
         */
        // 生成一个唯一标志，防止重复提交（响应到页面有一份，有一份保存到redis中）
        //String orderToken = IdWorker.getIdStr();
        // 获取orderToken
//        String orderToken = submitVO.getOrderToken();
        String orderToken = token.toString();
        // 1. 防重复提交，查询redis中有没有orderToken信息，
        //      有，则是第一次提交，放行并删除redis中的orderToken
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Long flag = (Long) this.redisTemplate.execute(new DefaultRedisScript<>(script, Long.class), Arrays.asList(TOKEN_PREFIX + orderToken), orderToken);
        if (flag == 0) {
            throw new Exception("订单不可重复提交！");
        }
        return null;
    }
}
