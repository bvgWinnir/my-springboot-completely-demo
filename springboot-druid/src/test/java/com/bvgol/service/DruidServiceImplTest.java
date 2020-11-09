package com.bvgol.service;

import com.bvgol.pojo.Druid;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @Classname DruidServiceImplTest
 * @Description TODO
 * @Date 2020/11/9 15:04
 * @Created by GUOCHEN
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidServiceImplTest {
    @Autowired
    private DruidService service;

    @org.junit.Test
    public void deleteByPrimaryKey() {
        service.deleteByPrimaryKey(null);
    }

    @org.junit.Test
    public void insert() {
        service.insert(Druid.builder().name("name" + LocalDateTime.now()).sex(false).build());
    }

    @org.junit.Test
    public void findLastInsert() {
        service.findLastInsert();
    }

    @org.junit.Test
    public void insertOrUpdate() {
    }

    @org.junit.Test
    public void insertOrUpdateSelective() {
    }

    @org.junit.Test
    public void insertSelective() {
    }

    @org.junit.Test
    public void selectByPrimaryKey() {
        Druid druid = service.selectByPrimaryKey(3);

    }

    @org.junit.Test
    public void updateByPrimaryKeySelective() {
    }

    @org.junit.Test
    public void updateByPrimaryKey() {
    }

    @org.junit.Test
    public void updateBatch() {
    }

    @org.junit.Test
    public void updateBatchSelective() {
    }

    @org.junit.Test
    public void batchInsert() {
    }
}
