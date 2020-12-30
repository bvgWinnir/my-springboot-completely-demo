package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysDept;
import com.bvgol.examples.springbootmybatisplus.model.SysDeptExample;

import java.util.List;

/**
 * @Classname SysDeptService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysDeptService extends IService<SysDept> {

    long countByExample(SysDeptExample example);

    int deleteByExample(SysDeptExample example);

    List<SysDept> selectByExample(SysDeptExample example);

    int updateByExampleSelective(SysDept record, SysDeptExample example);

    int updateByExample(SysDept record, SysDeptExample example);

    int updateBatch(List<SysDept> list);

    int updateBatchSelective(List<SysDept> list);

    int batchInsert(List<SysDept> list);

    int insertOrUpdate(SysDept record);

    int insertOrUpdateSelective(SysDept record);

}
