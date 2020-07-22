package com.bvgol.examples.springbootdocker.service;

import com.bvgol.examples.springbootdocker.model.Cron;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CronServiceImplTest {

    @Autowired
    private CronService cronService;

    @Test
    public void getById(){
        Cron byId = cronService.getById(1l);
        System.out.println(byId);
    }
}