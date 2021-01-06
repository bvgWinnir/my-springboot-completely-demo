package com.bvgol.examples.mockIto.service;

import com.bvgol.examples.mockIto.controller.UserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStaticMethod {

    @Autowired
    private UserController userController;

    /**
     * 测试启动前，首先 mock 出静态方法
     */
    @Before
    public void setUp() {
//        mockStatic(UserController.class);
        when(UserController.isTrue(any(String.class))).thenReturn(true);
    }

    /**
     * mock静态方法
     */
    @Test
    public void verifyStaticMock() {
        boolean flag = userController.verifyStaticMcok("");
        Assert.assertTrue(flag);
    }

}
