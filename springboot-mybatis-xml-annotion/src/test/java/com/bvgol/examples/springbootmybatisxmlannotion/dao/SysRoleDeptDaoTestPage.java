package com.bvgol.examples.springbootmybatisxmlannotion.dao;


import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysRoleDept;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysRoleDeptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname SysRoleDeptDaoTest
 * @Description 测试分页
 * @Date 2020/5/6 16:37
 * @Created by guochen
 */
@Slf4j
@SpringBootTest
public class SysRoleDeptDaoTestPage {
    @Resource
    private SysRoleDeptDao sysRoleDeptDao;

    @Resource
    private SysRoleDeptService sysRoleDeptService;

    /*
    mybatis 分页都有几种实现
    1.拦截器分页
        4.Mybatis分页插件PageHelper
        5.通用mapper?
    2.内存分页
    3.sql 分页

     */

    @Test
    void queryAll() {
        List<SysRoleDept> sysRoleDepts = sysRoleDeptDao.queryAll(null);
        Assert.assertEquals(5, sysRoleDepts.size());
        sysRoleDepts.forEach(System.out::println);
    }




}