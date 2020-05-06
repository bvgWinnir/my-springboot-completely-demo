package com.bvgol.examples.springbootmybatisxmlannotion.controller;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysOss;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysOssService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文件上传(SysOss)表控制层
 *
 * @author makejava
 * @since 2020-05-03 21:55:32
 */
@RestController
@RequestMapping("sysOss")
public class SysOssController {
    /**
     * 服务对象
     */
    @Resource
    private SysOssService sysOssService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysOss selectOne(Long id) {
        return this.sysOssService.queryById(id);
    }

}