package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysRole;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleExample;

import java.util.List;

/**
 * @Classname SysRoleService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysRoleService extends IService<SysRole> {

    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    List<SysRole> selectByExample(SysRoleExample example);

    int updateByExampleSelective(SysRole record, SysRoleExample example);

    int updateByExample(SysRole record, SysRoleExample example);

    int updateBatch(List<SysRole> list);

    int updateBatchSelective(List<SysRole> list);

    int batchInsert(List<SysRole> list);

    int insertOrUpdate(SysRole record);

    int insertOrUpdateSelective(SysRole record);

}
