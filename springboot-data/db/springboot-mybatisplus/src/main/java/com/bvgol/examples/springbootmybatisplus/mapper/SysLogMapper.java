package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysLog;
import com.bvgol.examples.springbootmybatisplus.model.SysLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SysLogMapper
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysLogMapper extends BaseMapper<SysLog> {
    long countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    List<SysLog> selectByExample(SysLogExample example);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateBatch(List<SysLog> list);

    int updateBatchSelective(List<SysLog> list);

    int batchInsert(@Param("list") List<SysLog> list);

    int insertOrUpdate(SysLog record);

    int insertOrUpdateSelective(SysLog record);
}
