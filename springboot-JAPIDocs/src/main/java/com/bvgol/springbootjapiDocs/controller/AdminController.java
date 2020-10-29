package com.bvgol.springbootjapiDocs.controller;

import com.bvgol.springbootjapiDocs.form.AdminForm;
import com.bvgol.springbootjapiDocs.vo.AdminVO;

import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 演示一些比较特殊的声明方法
 *
 * @author yeguozhong yedaxia.github.com
 * @description 管理员接口
 */
@Controller
public class AdminController {

    /**
     * 管理员登录
     *
     * @param name     登录名
     * @param password 密码
     */
    @RequestMapping(path = "/api/v1/admin/login", method = RequestMethod.GET)
    @ApiDoc(result = AdminVO.class, url = "/api/v1/admin/login2", method = "post")
    public void login(@RequestParam String name, @RequestParam String password) {

    }

    /**
     * 邮箱登录
     *
     * @param email
     * @param password
     */
    @RequestMapping(path = "/api/v1/admin/emailLogin", method = RequestMethod.POST)
    @ApiDoc(AdminVO.class)
    @Deprecated
    public void emailLogin(@RequestParam String email, String password) {

    }

    /**
     * 添加管理员
     *
     * @param adminForm 管理员信息
     */
    @PostMapping("/api/v1/admin/add")
    @ApiDoc(AdminVO.class)
    public void addAdmin(@RequestBody(required = false) AdminForm adminForm) {

    }

    /**
     * 添加多个管理员
     *
     * @param adminForms 管理员信息
     */
    @PostMapping("/api/v1/admin/addMany")
    @ApiDoc(AdminVO[].class)
    public void addAdmins(@RequestBody List<AdminForm> adminForms) {

    }
}