package com.bvgol.examples.springbootdocker.controller;

import com.bvgol.examples.springbootdocker.model.User;
import com.bvgol.examples.springbootdocker.service.UserService;
import com.bvgol.examples.springbootdocker.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController("/helloDocker")
public class HelloDockerController {

    @Value(value = "${server.port}")
    private String port;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/get/{str}")
    public String get(@PathVariable("str") String str) {
        return port + "----" + str + LocalDateTime.now();
    }

    @GetMapping("/getUserFromMysql/{id}")
    public User getUserFromMysql(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @GetMapping("/getUserFromRedis/{id}")
    public Object getUserFromRedis(@PathVariable("id") String id) {
        return redisUtil.get(id);
    }

    @PostMapping("postUser2Mysql")
    public Object postUser2Mysql(@RequestBody User user) {
        boolean save = userService.save(user);
        boolean set = redisUtil.set(user.getUserId() + "", user);

        return save == set;
    }

}
