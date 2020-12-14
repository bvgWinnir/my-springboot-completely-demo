package com.bvgol.examples.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bvgol.examples.springbootmybatisplus.mapper.UserMapper;
import com.bvgol.examples.springbootmybatisplus.model.User;
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
public class SampleMapperTest {

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
        queryWrapper.eq("name", "Sandy");
        List<User> userList = userMapper.selectList(queryWrapper);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectWithLambda() {
        System.out.println(("----- selectAll method testSelectWithLambda ------"));
        List<User> lambdaUsers = userMapper.selectList(new LambdaQueryWrapper<User>().eq(User::getUserId, 2L));
        lambdaUsers.forEach(System.out::println);
    }

    /**
     * Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
     * */


    @Test
    public void page(){
        Page page = new Page();
        IPage<User> userIPage = userMapper.selectPageVo(page, 1);

    }

    @Test
    public void page2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        Page page = userMapper.selectPage(new Page(1, 2), queryWrapper);

    }

    @Test
    public void insert(){
        User user = new User();
        user.setEmail("@qqq.qqcom");
        user.setUsername("xxxxxxxxxx2qq");
        userMapper.insert(user);

        User user1 = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getEmail, "@qqq.qqcom"));
        System.out.println(user1);
    }

    @Test
    public void logicDelete(){

        int i = userMapper.deleteById(902);
    }


    @Test
    public void versionTest(){

    }
}
