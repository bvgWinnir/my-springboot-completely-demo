package com.bvgol.examples.springbootmybatisxmlannotion.controller;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysDept;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysDeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 部门管理(SysDept)表控制层
 *
 * @author makejava
 * @since 2020-05-03 21:55:22
 */
@RestController
@RequestMapping("sysDept")
public class SysDeptController {
    /**
     * 服务对象
     */
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysDept selectOne(Long id) {
        return this.sysDeptService.queryById(id);
    }

}