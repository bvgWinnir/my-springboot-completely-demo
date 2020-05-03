package com.bvgol.examples.springbootmybatisplus;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.bvgol.examples.springbootmybatisplus.mapper.UserMapper;
import com.bvgol.examples.springbootmybatisplus.model.User;
import lombok.extern.slf4j.Slf4j;
import  org.junit.Test;
import  org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Classname SampleTest
 * @Description TODO
 * @Date 2020/4/26 16:10
 * @Created by guochen
 */
@Slf4j

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSelectWithWrapper() {
        System.out.println(("----- selectAll method testSelectWithWrapper ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","Sandy");
        List<User> userList = userMapper.selectList(queryWrapper);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectWithLambda() {
        System.out.println(("----- selectAll method testSelectWithLambda ------"));
        List<User> lambdaUsers = userMapper.selectList(new LambdaQueryWrapper<User>().eq(User::getId, 2L));
        lambdaUsers.forEach(System.out::println);
    }


}
