package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleMenu;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleMenuExample;

import java.util.List;

/**
 * @Classname SysRoleMenuService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    long countByExample(SysRoleMenuExample example);

    int deleteByExample(SysRoleMenuExample example);

    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    int updateByExampleSelective(SysRoleMenu record, SysRoleMenuExample example);

    int updateByExample(SysRoleMenu record, SysRoleMenuExample example);

    int updateBatch(List<SysRoleMenu> list);

    int updateBatchSelective(List<SysRoleMenu> list);

    int batchInsert(List<SysRoleMenu> list);

    int insertOrUpdate(SysRoleMenu record);

    int insertOrUpdateSelective(SysRoleMenu record);

}
