package com.bvgol.examples.springbootmybatisxmlannotion.service.impl;

import com.bvgol.examples.springbootmybatisxmlannotion.dao.SysConfigDao;
import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysConfig;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统配置信息表(SysConfig)表服务实现类
 *
 * @author makejava
 * @since 2020-05-03 21:55:20
 */
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
    @Resource
    private SysConfigDao sysConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysConfig queryById(Long id) {
        return this.sysConfigDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysConfig> queryAllByLimit(int offset, int limit) {
        return this.sysConfigDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    @Override
    public SysConfig insert(SysConfig sysConfig) {
        this.sysConfigDao.insert(sysConfig);
        return sysConfig;
    }

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    @Override
    public SysConfig update(SysConfig sysConfig) {
        this.sysConfigDao.update(sysConfig);
        return this.queryById(sysConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysConfigDao.deleteById(id) > 0;
    }
}