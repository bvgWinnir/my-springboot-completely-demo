package com.bvgol.examples.springbootmybatisxmlannotion.dao;


import cn.hutool.core.util.IdUtil;
import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysRoleDept;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Classname SysRoleDeptDaoTest
 * @Description Cascade   级联操作
 * @Date 2020/5/6 16:37
 * @Created by guochen
 */
@Slf4j
@SpringBootTest
public class SysRoleDeptDaoTestCascade {
    @Resource
    private SysRoleDeptDao sysRoleDeptDao;

    @Test
    void queryAll() {
        List<SysRoleDept> sysRoleDepts = sysRoleDeptDao.queryAll(null);
        Assert.assertEquals(5, sysRoleDepts.size());
        sysRoleDepts.forEach(System.out::println);
    }

    @Test
    void testInsertReturn(){

        SysRoleDept sysRoleDept = new SysRoleDept();
        sysRoleDept.setId(IdUtil.getSnowflake(1L,1L).nextId());
        sysRoleDept.setRoleId(0L);
        sysRoleDept.setDeptId(0L);

        int insert = sysRoleDeptDao.insert(sysRoleDept);

    }

    @Test
    //mysql 列经过类型转换 之后 的处理
    void testRestulMap(){
        Map<String , Object> count = sysRoleDeptDao.findCount();

        BigDecimal id = (BigDecimal)count.get("id");
        Long id_count = (Long)count.get("id_count");

        System.out.println("id = " + id);
        System.out.println("id_count = " + id_count);


    }

    @Test
    void testNoJdbcTyep(){

    }





}