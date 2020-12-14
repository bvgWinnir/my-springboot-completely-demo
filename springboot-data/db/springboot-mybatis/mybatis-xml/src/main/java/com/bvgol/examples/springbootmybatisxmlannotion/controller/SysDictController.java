package com.bvgol.examples.springbootmybatisxmlannotion.controller;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysDict;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysDictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 数据字典表(SysDict)表控制层
 *
 * @author makejava
 * @since 2020-05-03 21:55:29
 */
@RestController
@RequestMapping("sysDict")
public class SysDictController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictService sysDictService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysDict selectOne(Long id) {
        return this.sysDictService.queryById(id);
    }

}