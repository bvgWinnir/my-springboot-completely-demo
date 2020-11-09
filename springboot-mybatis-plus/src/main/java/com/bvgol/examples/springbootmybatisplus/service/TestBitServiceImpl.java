package com.bvgol.examples.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.TestBitMapper;
import com.bvgol.examples.springbootmybatisplus.model.TestBit;
import org.springframework.stereotype.Service;
@Service
public class TestBitServiceImpl extends ServiceImpl<TestBitMapper, TestBit> implements TestBitService{

}
