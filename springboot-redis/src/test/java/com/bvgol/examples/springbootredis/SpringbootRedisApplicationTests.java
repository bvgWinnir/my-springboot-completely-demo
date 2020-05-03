package com.bvgol.examples.springbootredis;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bvgol.examples.springbootredis.com.utils.RedisUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Resource
    private RedisUtil redisUtil ;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
    //没有注入




    JSONObject initJson(){
        JSONObject json = new JSONObject();
        json.put("id", IdUtil.createSnowflake(1L,1L).nextId());
        json.put("name","name"+ LocalDate.now());
        json.put("bri",new Date());
        return json;
    }



    @Test
    void contextLoads() {


    }

    @Test
    void RedisUtilsetJson(){
        redisUtil.set("json"+LocalDate.now(),initJson());
    }

    @Test
    void RedisUtilsetString(){
        redisUtil.set("xxxxx","xxxx2020年5月3日09:00:26");
        String xxxxx = (String)redisUtil.get("xxxxx");
        System.out.println(xxxxx);
    }

    @Test
    void RedisTemplatesetString(){
        redisTemplate.opsForValue().set("yyy","xxxx2020年5月3日09:00:26");
        String xxxxx = (String)redisUtil.get("yyy");
        System.out.println(xxxxx);
    }



}
