package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleDept;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleDeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SysRoleDeptMapper
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {
    long countByExample(SysRoleDeptExample example);

    int deleteByExample(SysRoleDeptExample example);

    List<SysRoleDept> selectByExample(SysRoleDeptExample example);

    int updateByExampleSelective(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    int updateByExample(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    int updateBatch(List<SysRoleDept> list);

    int updateBatchSelective(List<SysRoleDept> list);

    int batchInsert(@Param("list") List<SysRoleDept> list);

    int insertOrUpdate(SysRoleDept record);

    int insertOrUpdateSelective(SysRoleDept record);
}
