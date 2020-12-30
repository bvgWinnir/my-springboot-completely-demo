package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysConfigMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysConfig;
import com.bvgol.examples.springbootmybatisplus.model.SysConfigExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname SysConfigServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    @Override
    public long countByExample(SysConfigExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysConfigExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysConfig> selectByExample(SysConfigExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysConfig record, SysConfigExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysConfig record, SysConfigExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysConfig> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysConfig> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysConfig> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysConfig record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysConfig record) {
        return baseMapper.insertOrUpdateSelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public int insert(SysConfig build) {
        boolean save = this.save(build);
        return save ? 0 : 1;
    }
}
