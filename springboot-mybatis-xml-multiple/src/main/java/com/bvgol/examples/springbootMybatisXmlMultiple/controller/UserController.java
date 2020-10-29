package com.bvgol.examples.springbootMybatisXmlMultiple.controller;

import java.util.List;

import com.bvgol.examples.springbootMybatisXmlMultiple.domain.User;
import com.bvgol.examples.springbootMybatisXmlMultiple.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @date 2019-11-20 14:23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> userList() {
        return userService.listUser();
    }

    @RequestMapping("/update")
    public int update() {
        return userService.update();
    }
}