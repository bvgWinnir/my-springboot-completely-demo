package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysLogMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysLog;
import com.bvgol.examples.springbootmybatisplus.model.SysLogExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysLogServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public long countByExample(SysLogExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysLogExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysLog> selectByExample(SysLogExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysLog record, SysLogExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysLog record, SysLogExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysLog> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysLog> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysLog> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysLog record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysLog record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
