package com.bvgol.examples.springbootmybatisxmlannotion.dao;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysUserRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Classname Test1vs
 * @Description TODO
 * @Date 2020/5/25 21:57
 * @Created by guochen
 */
@Slf4j
@SpringBootTest
public class Test1vs {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Test
    public void onevs4() {
        SysUserRole sysUserRole = sysUserRoleDao.queryById(1L);
        System.out.println("sysUserRole = " + sysUserRole);
    }
}
