package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysConfig;
import com.bvgol.examples.springbootmybatisplus.model.SysConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SysConfigMapper
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    long countByExample(SysConfigExample example);

    int deleteByExample(SysConfigExample example);

    List<SysConfig> selectByExample(SysConfigExample example);

    int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    int updateBatch(List<SysConfig> list);

    int updateBatchSelective(List<SysConfig> list);

    int batchInsert(@Param("list") List<SysConfig> list);

    int insertOrUpdate(SysConfig record);

    int insertOrUpdateSelective(SysConfig record);
}
