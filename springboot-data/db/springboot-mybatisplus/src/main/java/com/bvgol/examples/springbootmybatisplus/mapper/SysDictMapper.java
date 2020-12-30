package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysDict;
import com.bvgol.examples.springbootmybatisplus.model.SysDictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SysDictMapper
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysDictMapper extends BaseMapper<SysDict> {
    long countByExample(SysDictExample example);

    int deleteByExample(SysDictExample example);

    List<SysDict> selectByExample(SysDictExample example);

    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateBatch(List<SysDict> list);

    int updateBatchSelective(List<SysDict> list);

    int batchInsert(@Param("list") List<SysDict> list);

    int insertOrUpdate(SysDict record);

    int insertOrUpdateSelective(SysDict record);
}
