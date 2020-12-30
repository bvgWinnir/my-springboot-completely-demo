package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleDept;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleDeptExample;

import java.util.List;

/**
 * @Classname SysRoleDeptService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysRoleDeptService extends IService<SysRoleDept> {

    long countByExample(SysRoleDeptExample example);

    int deleteByExample(SysRoleDeptExample example);

    List<SysRoleDept> selectByExample(SysRoleDeptExample example);

    int updateByExampleSelective(SysRoleDept record, SysRoleDeptExample example);

    int updateByExample(SysRoleDept record, SysRoleDeptExample example);

    int updateBatch(List<SysRoleDept> list);

    int updateBatchSelective(List<SysRoleDept> list);

    int batchInsert(List<SysRoleDept> list);

    int insertOrUpdate(SysRoleDept record);

    int insertOrUpdateSelective(SysRoleDept record);

}
