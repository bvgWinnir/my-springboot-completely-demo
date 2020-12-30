package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysDept;
import com.bvgol.examples.springbootmybatisplus.model.SysDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SysDeptMapper
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {
    long countByExample(SysDeptExample example);

    int deleteByExample(SysDeptExample example);

    List<SysDept> selectByExample(SysDeptExample example);

    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateBatch(List<SysDept> list);

    int updateBatchSelective(List<SysDept> list);

    int batchInsert(@Param("list") List<SysDept> list);

    int insertOrUpdate(SysDept record);

    int insertOrUpdateSelective(SysDept record);
}
