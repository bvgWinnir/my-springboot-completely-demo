package com.bvgol.examples.mockIto.service;

import com.bvgol.examples.mockIto.MockitoApplication;
import com.bvgol.examples.mockIto.eneity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MockitoApplication.class)
class Test2 {

    /**
     * 使用@Mock注解对测试接口进行修饰。该注解位于org.mockito.Mock中
     * 使用@mock注解会创建 Mock 对象 UserService
     * 等同于之前代码：
     * UserService userService = Mockito.mock(UserService.class);
     */
    @Mock
    private UserService userService;

    @Test
    void testUserService() {
        //UserService userService = Mockito.mock(UserService.class);

        User mockUser = new User();
        mockUser.setName("悟纤");
        mockUser.setId(1);

        //返回结果为：null
        System.out.println(userService.findById(1));

        //MOCK设置：当调用findById(1)的时候，返回mockUser对象。
        Mockito.when(userService.findById(1)).thenReturn(mockUser);

        //返回结果为：com.kfit.springbootmockitodemo.demo.bean.User@49aa766b
        System.out.println(userService.findById(1));

        Assert.assertEquals("悟纤", mockUser.getName());
    }

}
