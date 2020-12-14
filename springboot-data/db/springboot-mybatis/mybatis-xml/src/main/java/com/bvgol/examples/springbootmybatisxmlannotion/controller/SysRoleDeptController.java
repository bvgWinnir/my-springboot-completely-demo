package com.bvgol.examples.springbootmybatisxmlannotion.controller;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysRoleDept;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysRoleDeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色与部门对应关系(SysRoleDept)表控制层
 *
 * @author makejava
 * @since 2020-05-03 21:55:34
 */
@RestController
@RequestMapping("sysRoleDept")
public class SysRoleDeptController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysRoleDept selectOne(Long id) {
        return this.sysRoleDeptService.queryById(id);
    }

}