package com.bvgol.examples.springbootmybatisxmlannotion.service.impl;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysRoleDept;
import com.bvgol.examples.springbootmybatisxmlannotion.dao.SysRoleDeptDao;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysRoleDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色与部门对应关系(SysRoleDept)表服务实现类
 *
 * @author makejava
 * @since 2020-05-03 21:55:34
 */
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl implements SysRoleDeptService {
    @Resource
    private SysRoleDeptDao sysRoleDeptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRoleDept queryById(Long id) {
        return this.sysRoleDeptDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRoleDept> queryAllByLimit(int offset, int limit) {
        return this.sysRoleDeptDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRoleDept 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleDept insert(SysRoleDept sysRoleDept) {
        this.sysRoleDeptDao.insert(sysRoleDept);
        return sysRoleDept;
    }

    /**
     * 修改数据
     *
     * @param sysRoleDept 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleDept update(SysRoleDept sysRoleDept) {
        this.sysRoleDeptDao.update(sysRoleDept);
        return this.queryById(sysRoleDept.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysRoleDeptDao.deleteById(id) > 0;
    }
}