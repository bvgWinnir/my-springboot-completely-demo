package com.bvgol.examples.springbootmybatisxmlannotion.controller;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysLog;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统日志(SysLog)表控制层
 *
 * @author makejava
 * @since 2020-05-03 21:55:31
 */
@RestController
@RequestMapping("sysLog")
public class SysLogController {
    /**
     * 服务对象
     */
    @Resource
    private SysLogService sysLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysLog selectOne(Long id) {
        return this.sysLogService.queryById(id);
    }

}