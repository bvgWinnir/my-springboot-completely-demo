package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysRoleMenuMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleMenu;
import com.bvgol.examples.springbootmybatisplus.model.SysRoleMenuExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysRoleMenuServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Override
    public long countByExample(SysRoleMenuExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysRoleMenuExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysRoleMenu> selectByExample(SysRoleMenuExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysRoleMenu record, SysRoleMenuExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysRoleMenu record, SysRoleMenuExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysRoleMenu> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysRoleMenu> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysRoleMenu> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysRoleMenu record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysRoleMenu record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
