package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysLog;
import com.bvgol.examples.springbootmybatisplus.model.SysLogExample;

import java.util.List;

/**
 * @Classname SysLogService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysLogService extends IService<SysLog> {

    long countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    List<SysLog> selectByExample(SysLogExample example);

    int updateByExampleSelective(SysLog record, SysLogExample example);

    int updateByExample(SysLog record, SysLogExample example);

    int updateBatch(List<SysLog> list);

    int updateBatchSelective(List<SysLog> list);

    int batchInsert(List<SysLog> list);

    int insertOrUpdate(SysLog record);

    int insertOrUpdateSelective(SysLog record);

}
