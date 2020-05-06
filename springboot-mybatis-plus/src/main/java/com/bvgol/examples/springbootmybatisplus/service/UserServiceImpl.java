package com.bvgol.examples.springbootmybatisplus.service;

import com.bvgol.examples.springbootmybatisplus.mapper.UserMapper;
import com.bvgol.examples.springbootmybatisplus.model.User;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/5/6 9:11
 * @Created by guochen
 */
 @Slf4j
 
  
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
