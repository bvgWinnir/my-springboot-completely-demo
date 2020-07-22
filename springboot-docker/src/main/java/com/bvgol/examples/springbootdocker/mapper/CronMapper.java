package com.bvgol.examples.springbootdocker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bvgol.examples.springbootdocker.model.Cron;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface CronMapper extends BaseMapper<Cron> {

}