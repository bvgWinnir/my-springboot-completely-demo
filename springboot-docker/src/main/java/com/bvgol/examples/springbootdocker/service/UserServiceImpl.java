package com.bvgol.examples.springbootdocker.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootdocker.mapper.UserMapper;
import com.bvgol.examples.springbootdocker.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/5/6 9:11
 * @Created by guochen
 */
@Slf4j

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
