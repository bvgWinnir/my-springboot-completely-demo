package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysOssMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysOss;
import com.bvgol.examples.springbootmybatisplus.model.SysOssExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysOssServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysOssServiceImpl extends ServiceImpl<SysOssMapper, SysOss> implements SysOssService {

    @Override
    public long countByExample(SysOssExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysOssExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysOss> selectByExample(SysOssExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysOss record, SysOssExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysOss record, SysOssExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysOss> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysOss> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysOss> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysOss record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysOss record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
