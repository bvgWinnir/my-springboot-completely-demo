package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysRoleDeptMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleDept;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleDeptExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysRoleDeptServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements SysRoleDeptService {

    @Override
    public long countByExample(SysRoleDeptExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysRoleDeptExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysRoleDept> selectByExample(SysRoleDeptExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysRoleDept record, SysRoleDeptExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysRoleDept record, SysRoleDeptExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysRoleDept> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysRoleDept> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysRoleDept> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysRoleDept record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysRoleDept record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
