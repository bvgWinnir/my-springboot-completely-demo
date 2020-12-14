package com.bvgol.examples.springbootmybatisplus;

import com.bvgol.examples.springbootmybatisplus.model.User;
import com.bvgol.examples.springbootmybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @Classname SampleMapperTest
 * @Description TODO
 * @Date 2020/4/26 16:10
 * @Created by guochen
 */
@Slf4j

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServcieInsertTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertOne() {
        User u = new User();
        u.setUsername("haha"+ LocalDateTime.now());
        u.setPassword("222");
        u.setSalt("222");
        u.setEmail("222");
        u.setMobile("222");
        u.setStatus((byte)0);
        u.setDeptId(0L);
//        u.setCreateTime(new Date());
//        u.setUpdateTime(new Date());
//        u.setVersion(0);
//        u.setDeleted(0);

         userService.save(u);
    }

//		boolean update = this.update(new LambdaQueryChainWrapper<CenterOrderSalesMain>(baseMapper).select(CenterOrderSalesMain::getId, CenterOrderSalesMain::getStatus));
}
