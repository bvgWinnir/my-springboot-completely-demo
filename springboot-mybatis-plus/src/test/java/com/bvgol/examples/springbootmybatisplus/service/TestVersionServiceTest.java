package com.bvgol.examples.springbootmybatisplus.service;

import com.bvgol.examples.springbootmybatisplus.model.TestVersion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.awt.geom.PathIterator;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @Classname TestVersionServiceTest
 * @Description TODO
 * @Date 2020/10/27 13:35
 * @Created by GUOCHEN
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVersionServiceTest {

    @Autowired
    private TestVersionService testVersionService;

    @Test
    public void insert(){
        TestVersion build = TestVersion.builder().name(LocalDateTime.now().toString()).build();
        testVersionService.save(build);
    }

    @Test
    public void testVersionUpdate(){
        //模拟查出来的/页面看到的
//        TestVersion build = TestVersion.builder().id(1).name("3").version(1).build();
        TestVersion build = TestVersion.builder().id(1).name("4444").build();
        boolean b = testVersionService.updateById(build);
        Assert.isTrue(b,"没有更新成功");
    }


    @Test
    public void testINt(){
        System.out.println(0);
    }
}
