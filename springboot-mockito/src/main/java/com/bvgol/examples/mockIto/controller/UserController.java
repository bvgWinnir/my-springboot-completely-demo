package com.bvgol.examples.mockIto.controller;

import com.bvgol.examples.mockIto.eneity.User;
import com.bvgol.examples.mockIto.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @RequestMapping("/findById")
    public User findById(int id) {
        return userService.findById(id);
    }

    /**
     * Mock 静态方法 isTrue
     *
     * @param userName
     * @return
     */
    public boolean verifyStaticMcok(String userName) {
        boolean flag = isTrue(userName);
        System.out.println("校验用户名：" + flag);
        return flag;
    }

    /**
     * 静态方法
     *
     * @param userName 用户名不能为空
     */
    public static final boolean isTrue(String userName) {
        if (userName == null || "".equals(userName)) {
            return false;
        }
        return true;
    }
}
