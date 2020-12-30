package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysDeptMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysDept;
import com.bvgol.examples.springbootmybatisplus.model.SysDeptExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysDeptServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public long countByExample(SysDeptExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysDeptExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysDept> selectByExample(SysDeptExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysDept record, SysDeptExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysDept record, SysDeptExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysDept> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysDept> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysDept> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysDept record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysDept record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
