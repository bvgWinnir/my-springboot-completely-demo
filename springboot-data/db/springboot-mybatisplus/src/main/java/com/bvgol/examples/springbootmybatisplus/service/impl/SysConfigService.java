package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysConfig;
import com.bvgol.examples.springbootmybatisplus.model.SysConfigExample;

import java.util.List;

/**
 * @Classname SysConfigService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysConfigService extends IService<SysConfig> {

    long countByExample(SysConfigExample example);

    int deleteByExample(SysConfigExample example);

    List<SysConfig> selectByExample(SysConfigExample example);

    int updateByExampleSelective(SysConfig record, SysConfigExample example);

    int updateByExample(SysConfig record, SysConfigExample example);

    int updateBatch(List<SysConfig> list);

    int updateBatchSelective(List<SysConfig> list);

    int batchInsert(List<SysConfig> list);

    int insertOrUpdate(SysConfig record);

    int insertOrUpdateSelective(SysConfig record);

    int insert(SysConfig build);
}
