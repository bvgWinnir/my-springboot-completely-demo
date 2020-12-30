package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.TestVersion;
import com.bvgol.examples.springbootmybatisplus.model.TestVersionExample;

import java.util.List;

/**
 * @Classname TestVersionService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface TestVersionService extends IService<TestVersion> {

    long countByExample(TestVersionExample example);

    int deleteByExample(TestVersionExample example);

    List<TestVersion> selectByExample(TestVersionExample example);

    int updateByExampleSelective(TestVersion record, TestVersionExample example);

    int updateByExample(TestVersion record, TestVersionExample example);

    int updateBatch(List<TestVersion> list);

    int updateBatchSelective(List<TestVersion> list);

    int batchInsert(List<TestVersion> list);

    int insertOrUpdate(TestVersion record);

    int insertOrUpdateSelective(TestVersion record);

}
