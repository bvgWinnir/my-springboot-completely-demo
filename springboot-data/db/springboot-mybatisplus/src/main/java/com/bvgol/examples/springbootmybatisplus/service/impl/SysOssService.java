package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.SysOss;
import com.bvgol.examples.springbootmybatisplus.model.SysOssExample;

import java.util.List;

/**
 * @Classname SysOssService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysOssService extends IService<SysOss> {

    long countByExample(SysOssExample example);

    int deleteByExample(SysOssExample example);

    List<SysOss> selectByExample(SysOssExample example);

    int updateByExampleSelective(SysOss record, SysOssExample example);

    int updateByExample(SysOss record, SysOssExample example);

    int updateBatch(List<SysOss> list);

    int updateBatchSelective(List<SysOss> list);

    int batchInsert(List<SysOss> list);

    int insertOrUpdate(SysOss record);

    int insertOrUpdateSelective(SysOss record);

}
