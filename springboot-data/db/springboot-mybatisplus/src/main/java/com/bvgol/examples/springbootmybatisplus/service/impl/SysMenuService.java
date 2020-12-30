package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysMenu;
import com.bvgol.examples.springbootmybatisplus.model.SysMenuExample;

import java.util.List;

/**
 * @Classname SysMenuService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysMenuService extends IService<SysMenu> {

    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    List<SysMenu> selectByExample(SysMenuExample example);

    int updateByExampleSelective(SysMenu record, SysMenuExample example);

    int updateByExample(SysMenu record, SysMenuExample example);

    int updateBatch(List<SysMenu> list);

    int updateBatchSelective(List<SysMenu> list);

    int batchInsert(List<SysMenu> list);

    int insertOrUpdate(SysMenu record);

    int insertOrUpdateSelective(SysMenu record);

}
