package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.TestBit;
import com.bvgol.examples.springbootmybatisplus.model.TestBitExample;

import java.util.List;

/**
 * @Classname TestBitService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface TestBitService extends IService<TestBit> {

    long countByExample(TestBitExample example);

    int deleteByExample(TestBitExample example);

    List<TestBit> selectByExample(TestBitExample example);

    int updateByExampleSelective(TestBit record, TestBitExample example);

    int updateByExample(TestBit record, TestBitExample example);

    int updateBatch(List<TestBit> list);

    int updateBatchSelective(List<TestBit> list);

    int batchInsert(List<TestBit> list);

    int insertOrUpdate(TestBit record);

    int insertOrUpdateSelective(TestBit record);

}
