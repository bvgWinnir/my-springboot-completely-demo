package com.bvgol.examples.springbootmybatisxmlannotion.dao;

import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysOss;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文件上传(SysOss)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-03 21:55:32
 */
public interface SysOssDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOss queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOss> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysOss 实例对象
     * @return 对象列表
     */
    List<SysOss> queryAll(SysOss sysOss);

    /**
     * 新增数据
     *
     * @param sysOss 实例对象
     * @return 影响行数
     */
    int insert(SysOss sysOss);

    /**
     * 修改数据
     *
     * @param sysOss 实例对象
     * @return 影响行数
     */
    int update(SysOss sysOss);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}