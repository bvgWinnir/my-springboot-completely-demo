package com.bvgol.examples.springbootmybatisxmlannotion.service;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysRoleDept;
import java.util.List;

/**
 * 角色与部门对应关系(SysRoleDept)表服务接口
 *
 * @author makejava
 * @since 2020-05-03 21:55:34
 */
public interface SysRoleDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRoleDept queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysRoleDept> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysRoleDept 实例对象
     * @return 实例对象
     */
    SysRoleDept insert(SysRoleDept sysRoleDept);

    /**
     * 修改数据
     *
     * @param sysRoleDept 实例对象
     * @return 实例对象
     */
    SysRoleDept update(SysRoleDept sysRoleDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}