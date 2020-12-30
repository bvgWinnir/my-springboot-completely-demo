package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysOss;
import com.bvgol.examples.springbootmybatisplus.model.SysOssExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SysOssMapper
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysOssMapper extends BaseMapper<SysOss> {
    long countByExample(SysOssExample example);

    int deleteByExample(SysOssExample example);

    List<SysOss> selectByExample(SysOssExample example);

    int updateByExampleSelective(@Param("record") SysOss record, @Param("example") SysOssExample example);

    int updateByExample(@Param("record") SysOss record, @Param("example") SysOssExample example);

    int updateBatch(List<SysOss> list);

    int updateBatchSelective(List<SysOss> list);

    int batchInsert(@Param("list") List<SysOss> list);

    int insertOrUpdate(SysOss record);

    int insertOrUpdateSelective(SysOss record);
}
