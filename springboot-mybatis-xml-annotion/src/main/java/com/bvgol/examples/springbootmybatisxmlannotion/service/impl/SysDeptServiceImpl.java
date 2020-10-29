package com.bvgol.examples.springbootmybatisxmlannotion.service.impl;

import com.bvgol.examples.springbootmybatisxmlannotion.dao.SysDeptDao;
import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysDept;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理(SysDept)表服务实现类
 *
 * @author makejava
 * @since 2020-05-03 21:55:22
 */
@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {
    @Resource
    private SysDeptDao sysDeptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deptId 主键
     * @return 实例对象
     */
    @Override
    public SysDept queryById(Long deptId) {
        return this.sysDeptDao.queryById(deptId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysDept> queryAllByLimit(int offset, int limit) {
        return this.sysDeptDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    @Override
    public SysDept insert(SysDept sysDept) {
        this.sysDeptDao.insert(sysDept);
        return sysDept;
    }

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    @Override
    public SysDept update(SysDept sysDept) {
        this.sysDeptDao.update(sysDept);
        return this.queryById(sysDept.getDeptId());
    }

    /**
     * 通过主键删除数据
     *
     * @param deptId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long deptId) {
        return this.sysDeptDao.deleteById(deptId) > 0;
    }
}