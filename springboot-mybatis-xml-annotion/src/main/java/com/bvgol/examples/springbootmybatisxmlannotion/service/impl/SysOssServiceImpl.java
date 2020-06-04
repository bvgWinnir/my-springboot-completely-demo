package com.bvgol.examples.springbootmybatisxmlannotion.service.impl;

import com.bvgol.examples.springbootmybatisxmlannotion.dao.SysOssDao;
import com.bvgol.examples.springbootmybatisxmlannotion.entity.SysOss;
import com.bvgol.examples.springbootmybatisxmlannotion.service.SysOssService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件上传(SysOss)表服务实现类
 *
 * @author makejava
 * @since 2020-05-03 21:55:32
 */
@Service("sysOssService")
public class SysOssServiceImpl implements SysOssService {
    @Resource
    private SysOssDao sysOssDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysOss queryById(Long id) {
        return this.sysOssDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysOss> queryAllByLimit(int offset, int limit) {
        return this.sysOssDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysOss 实例对象
     * @return 实例对象
     */
    @Override
    public SysOss insert(SysOss sysOss) {
        this.sysOssDao.insert(sysOss);
        return sysOss;
    }

    /**
     * 修改数据
     *
     * @param sysOss 实例对象
     * @return 实例对象
     */
    @Override
    public SysOss update(SysOss sysOss) {
        this.sysOssDao.update(sysOss);
        return this.queryById(sysOss.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysOssDao.deleteById(id) > 0;
    }
}