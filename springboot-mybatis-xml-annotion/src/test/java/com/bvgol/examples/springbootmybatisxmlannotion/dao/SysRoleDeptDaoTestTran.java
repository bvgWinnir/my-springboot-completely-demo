package com.bvgol.examples.springbootmybatisxmlannotion.dao;


import cn.hutool.core.util.IdUtil;
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
 * @Description 测试事务如何生效
 * @Date 2020/5/6 16:37
 * @Created by guochen
 */
@Slf4j
@SpringBootTest
public class SysRoleDeptDaoTestTran {
    @Resource
    private SysRoleDeptDao sysRoleDeptDao;

    @Resource
    private SysRoleDeptService sysRoleDeptService;

    @Test
    void queryAll() {
        List<SysRoleDept> sysRoleDepts = sysRoleDeptDao.queryAll(null);
        Assert.assertEquals(5, sysRoleDepts.size());
        sysRoleDepts.forEach(System.out::println);
    }


    //测试事务

    @Test
    void  testInsert001(){
        // 生成之后的模板代码 001
        SysRoleDept sysRoleDept = new SysRoleDept();
        sysRoleDept.setId(IdUtil.getSnowflake(1L,1L).nextId());
        sysRoleDept.setRoleId(0L);
        sysRoleDept.setDeptId(0L);

        int insert = sysRoleDeptDao.insert(sysRoleDept);
        Assert.assertEquals(1, insert);

    }

    @Test
    void  testInsert002() throws Exception {
        // 生成之后的模板代码 002
        // 没有事务的情况下 insert已经生效提交 之后报错不会回滚
        SysRoleDept sysRoleDept = new SysRoleDept();
        sysRoleDept.setId(IdUtil.getSnowflake(1L,1L).nextId());
        sysRoleDept.setRoleId(0L);
        sysRoleDept.setDeptId(0L);

        int insert = sysRoleDeptDao.insert(sysRoleDept);
        Assert.assertEquals(1, insert);
        throw new Exception();

    }

    @Test
    void  testInsert003() throws Exception {
        // 生成之后的模板代码 002
        // 在 实现类上加了事务注解 却依旧没有生效
        SysRoleDept sysRoleDept = new SysRoleDept();
        sysRoleDept.setId(IdUtil.getSnowflake(1L,1L).nextId());
        sysRoleDept.setRoleId(0L);
        sysRoleDept.setDeptId(0L);

        SysRoleDept insert = sysRoleDeptService.insert(sysRoleDept);
        Assert.assertEquals(4L, (long)insert.getId());
        throw new Exception();
    }

    @Test
    void  testInsert004() throws Exception {

        // 事务在这个情况下生效了
        // 需要在方法级别抛出异常
        //try中的异常需要在 catch中抛出
        SysRoleDept sysRoleDept = new SysRoleDept();
        sysRoleDept.setId(4L);
        sysRoleDept.setRoleId(44L);
        sysRoleDept.setDeptId(0L);

        Integer integer = sysRoleDeptService.updateE(sysRoleDept);

        Assert.assertEquals(1L, integer.longValue());
    }

    @Test
    void  testInsert005() throws Exception {

        // 事务在这个情况下不生效了
        // 需要在方法级别抛出异常
        //try中的异常需要在 catch中不抛出
        SysRoleDept sysRoleDept = new SysRoleDept();
        sysRoleDept.setId(4L);
        sysRoleDept.setRoleId(440L);
        sysRoleDept.setDeptId(0L);

        Integer integer = sysRoleDeptService.updateNotthrow(sysRoleDept);

        Assert.assertEquals(1L, integer.longValue());
    }



}