//package com.bvgol.examples.springbootredis;
//
////import com.bvgol.examples.springbootredis.com.utils.RedisUtil;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//
///**
// * @author guochen
// * @Title:
// * @Package
// * @Description:
// * @date 2020/6/2814:57
// */
//@Slf4j
//@SpringBootTesta
//public class RedisQuere {
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    @Test
//    public void listADD() {
//        Long aLong = redisTemplate.opsForList().leftPush("list-left-push", "qqq");
//        redisTemplate.opsForList().leftPush("list-left-push", "www");
//        redisTemplate.opsForList().leftPush("list-left-push", "eee");
//        redisTemplate.opsForList().leftPush("list-left-push", "rrr");
//        redisTemplate.opsForList().leftPush("list-left-push", "aaa");
//        System.out.println(aLong + "");
//        Object leftPop = redisTemplate.opsForList().leftPop("list-left-push");
//        System.out.println(leftPop + "");
//
//        //随机取
//    }
//
//    @Test
//    public void listadd2() {
//
//        //顺序取
//    }
//
//    @Test
//    public void leftpop() {
//
//    }
//
//    @Test
//    public void rightpop() {
//
//    }
//}
