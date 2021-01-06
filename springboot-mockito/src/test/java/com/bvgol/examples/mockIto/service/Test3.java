package com.bvgol.examples.mockIto.service;

import com.bvgol.examples.mockIto.Dao.UserDao;
import com.bvgol.examples.mockIto.MockitoApplication;
import com.bvgol.examples.mockIto.eneity.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = MockitoApplication.class)
class Test3 {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    void testUserService() {

        User mockUser = new User();
        mockUser.setName("mock师傅");
        mockUser.setId(1);

        //MOCK设置：当调用findById(1)的时候，返回mockUser对象。
        Mockito.when(userDao.findById(1)).thenReturn(mockUser);
        //User{id=1, name='mock师傅'}
        System.out.println(userService.findById(1));

        Assert.assertEquals("mock师傅", mockUser.getName());
    }

}
