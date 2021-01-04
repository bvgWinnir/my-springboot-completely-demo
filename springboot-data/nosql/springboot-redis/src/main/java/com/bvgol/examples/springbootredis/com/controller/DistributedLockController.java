package com.bvgol.examples.springbootredis.com.controller;

import com.bvgol.examples.springbootredis.com.entity.Book;
import com.bvgol.examples.springbootredis.com.lockAspect.RedisLockAnnotation;
import com.bvgol.examples.springbootredis.com.lockAspect.RedisLockTypeEnum;
import com.bvgol.examples.springbootredis.com.service.logic.LogicService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @program: my-springboot-completely
 * @description: 分布式锁&锁数据
 * @author: GUOCHEN
 * @create: 2021/01/04 09:10
 */
@Slf4j
@RestController
@AllArgsConstructor
public class DistributedLockController {

    private RedisTemplate redisTemplate;
    private LogicService logicService;
//    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/testRedis")
    public Book getForRedis() {
        ValueOperations<String, String> ops1 = redisTemplate.opsForValue();
        ops1.set("name", "Go 语言实战");
        String name = ops1.get("name");
        System.out.println(name);
        ValueOperations ops2 = redisTemplate.opsForValue();
        Book book = (Book) ops2.get("b1");
        if (book == null) {
            book = Book.builder().author("Go 语言实战").id(2).name("none name").price(BigDecimal.ONE).build();
            ops2.set("b1", book);
        }
        return book;
    }

    /**
     * 功能描述: 测试感觉 是接口锁 请求到这里需要one by one
     *
     * @param userId
     * @return: com.bvgol.examples.springbootredis.com.entity.Book
     * @author: 郭辰
     * @date: 2021/1/4 13:57
     */
    @GetMapping("/testRedisLock")
    @RedisLockAnnotation(typeEnum = RedisLockTypeEnum.ONE, lockTime = 3)
    public Book testRedisLock(@RequestParam("userId") Long userId) {
        try {
            log.info("睡眠执行前");
            Thread.sleep(10000);
            log.info("睡眠执行后");
        } catch (Exception e) {
            // log error
            log.info("has some error", e);
        }
        return Book.builder().name("请求结束").build();
    }

    /**
     * 功能描述: 分布式锁`数据锁 非注解版
     *
     * @param token
     * @return: com.bvgol.examples.springbootredis.com.entity.Book
     * @author: 郭辰
     * @date: 2021/1/4 13:57
     */
    @GetMapping("/testDistributedLockByRedis")
    public Book testDistributedLockByRedis(@RequestParam("token") Integer token) {
        Book book = null;
        try {
            book = logicService.logic(token);
        } catch (Exception e) {
            // log error
            log.info("has some error", e);
        }
        return book;
    }

    /**
     * 功能描述: 分布式锁`数据锁 注解版
     *
     * @param userId
     * @return: com.bvgol.examples.springbootredis.com.entity.Book
     * @author: 郭辰
     * @date: 2021/1/4 13:57
     */
    @GetMapping("/testDistributedLockByRedisAnn")
    public Book testDistributedLockByRedisAnn(@RequestParam("userId") Integer userId) {
        try {
            log.info("睡眠执行前");
            Thread.sleep(10000);
            log.info("睡眠执行后");
        } catch (Exception e) {
            // log error
            log.info("has some error", e);
        }
        return Book.builder().name("请求结束").id(userId).build();
    }

}
