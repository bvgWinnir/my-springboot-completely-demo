package com.bvgol.examples.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bvgol.examples.springbootmybatisplus.model.User;
import com.bvgol.examples.springbootmybatisplus.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Classname SampleMapperTest
 * @Description TODO
 * @Date 2020/4/26 16:10
 * @Created by guochen
 */
@Slf4j

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServcieTest {

//    @Autowired
//    private TestBitService testBitService;

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.list(null);
//        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSelectWithWrapper() {
        System.out.println(("----- selectAll method testSelectWithWrapper ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","Sandy");
        List<User> userList = userService.list(queryWrapper);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectWithLambda() {
        System.out.println(("----- selectAll method testSelectWithLambda ------"));
        List<User> lambdaUsers = userService.list(new LambdaQueryWrapper<User>().eq(User::getUserId, 2L));
        lambdaUsers.forEach(System.out::println);
    }

//    @Test
//    public void testbit(){
//        List<TestBit> list = testBitService.list();
//        list.forEach(System.out::println);
//
//        //bit 0==false   1==true
//        //TestBit(id=1, sex=false, name=111, brithday=null)
//        //TestBit(id=2, sex=true, name=222, brithday=Tue Sep 01 11:37:30 CST 2020)
//    }

}
