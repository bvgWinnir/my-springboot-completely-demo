package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.SysUserRoleMapper;
import com.bvgol.examples.springbootmybatisplus.model.SysUserRole;
import com.bvgol.examples.springbootmybatisplus.model.SysUserRoleExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SysUserRoleServiceImpl
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    public long countByExample(SysUserRoleExample example) {
        return baseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysUserRoleExample example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    public List<SysUserRole> selectByExample(SysUserRoleExample example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysUserRole record, SysUserRoleExample example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysUserRole record, SysUserRoleExample example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    public int updateBatch(List<SysUserRole> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysUserRole> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysUserRole> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(SysUserRole record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(SysUserRole record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
