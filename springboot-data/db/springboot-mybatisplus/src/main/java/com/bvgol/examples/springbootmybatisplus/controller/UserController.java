package com.bvgol.examples.springbootmybatisplus.controller;

import com.bvgol.examples.springbootmybatisplus.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Object findAll(){
        return userService.list();
    }
}
