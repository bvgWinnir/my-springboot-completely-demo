package com.bvgol.examples.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysMenu;
import com.bvgol.examples.springbootmybatisplus.model.SysMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SysMenuMapper
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    List<SysMenu> selectByExample(SysMenuExample example);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateBatch(List<SysMenu> list);

    int updateBatchSelective(List<SysMenu> list);

    int batchInsert(@Param("list") List<SysMenu> list);

    int insertOrUpdate(SysMenu record);

    int insertOrUpdateSelective(SysMenu record);
}
