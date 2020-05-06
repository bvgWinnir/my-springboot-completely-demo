package com.bvgol.examples.springbootmybatisxmlannotion.service;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysOss;
import java.util.List;

/**
 * 文件上传(SysOss)表服务接口
 *
 * @author makejava
 * @since 2020-05-03 21:55:32
 */
public interface SysOssService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOss queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOss> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysOss 实例对象
     * @return 实例对象
     */
    SysOss insert(SysOss sysOss);

    /**
     * 修改数据
     *
     * @param sysOss 实例对象
     * @return 实例对象
     */
    SysOss update(SysOss sysOss);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}