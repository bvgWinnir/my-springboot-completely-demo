package com.bvgol.examples.springbootmybatisplus;/**
 * @Classname BatchTest
 * @Description TODO
 * @Date 2020/12/14 17:45
 * @Created by GUOCHEN
 */

import com.bvgol.examples.springbootmybatisplus.model.User;
import com.bvgol.examples.springbootmybatisplus.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/12/14 17:45
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchTest {
    @Autowired
    private UserService userService;

    @Test
    public void batchInsert() {
        List<User> list = Arrays.asList(
                User.builder().username("").build(),
                User.builder().username("").build(),
                User.builder().username("").build(),
                User.builder().username("").build(),
                User.builder().username("").build()
        );

        boolean b = userService.saveBatch(list);

    }
}
