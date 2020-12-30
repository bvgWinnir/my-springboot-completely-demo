package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysMenuMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysMenu;
import com.bvgol.examples.springbootmybatisplus.model.SysMenuExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysMenuServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public long countByExample(SysMenuExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysMenuExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysMenu> selectByExample(SysMenuExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysMenu record, SysMenuExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysMenu record, SysMenuExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysMenu> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysMenu> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysMenu> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysMenu record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysMenu record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
