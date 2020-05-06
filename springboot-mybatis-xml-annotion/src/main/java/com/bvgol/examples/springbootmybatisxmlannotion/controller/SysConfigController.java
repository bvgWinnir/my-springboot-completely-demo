package com.bvgol.examples.springbootmybatisxmlannotion.controller;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysConfig;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统配置信息表(SysConfig)表控制层
 *
 * @author makejava
 * @since 2020-05-03 21:55:20
 */
@RestController
@RequestMapping("sysConfig")
public class SysConfigController {
    /**
     * 服务对象
     */
    @Resource
    private SysConfigService sysConfigService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysConfig selectOne(Long id) {
        return this.sysConfigService.queryById(id);
    }

}