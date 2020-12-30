package com.bvgol.examples.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bvgol.examples.springbootmybatisplus.model.TbToken;
import com.bvgol.examples.springbootmybatisplus.model.TbTokenExample;

import java.util.List;

/**
 * @Classname TbTokenService
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */
public interface TbTokenService extends IService<TbToken> {

    long countByExample(TbTokenExample example);

    int deleteByExample(TbTokenExample example);

    List<TbToken> selectByExample(TbTokenExample example);

    int updateByExampleSelective(TbToken record, TbTokenExample example);

    int updateByExample(TbToken record, TbTokenExample example);

    int updateBatch(List<TbToken> list);

    int updateBatchSelective(List<TbToken> list);

    int batchInsert(List<TbToken> list);

    int insertOrUpdate(TbToken record);

    int insertOrUpdateSelective(TbToken record);

}
