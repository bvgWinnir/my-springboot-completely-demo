package com.bvgol.examples.springbootdocker.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootdocker.mapper.CronMapper;
import com.bvgol.examples.springbootdocker.model.Cron;
import org.springframework.stereotype.Service;
@Service
public class CronServiceImpl extends ServiceImpl<CronMapper, Cron> implements CronService{

}
