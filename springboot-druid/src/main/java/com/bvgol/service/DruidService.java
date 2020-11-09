package com.bvgol.service;

import com.bvgol.pojo.Druid;

import java.util.List;
import java.util.Map;

/**
 * @Classname DruidService
 * @Description TODO
 * @Date 2020/11/9 14:11
 * @Created by GUOCHEN
 */
public interface DruidService {

    int deleteByPrimaryKey(Integer id);

    int insert(Druid record);

    int insertOrUpdate(Druid record);

    int insertOrUpdateSelective(Druid record);

    int insertSelective(Druid record);

    Druid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Druid record);

    int updateByPrimaryKey(Druid record);

    int updateBatch(List<Druid> list);

    int updateBatchSelective(List<Druid> list);

    int batchInsert(List<Druid> list);

    List<Map<String, Object>> findLastInsert();

    Object error();
}
