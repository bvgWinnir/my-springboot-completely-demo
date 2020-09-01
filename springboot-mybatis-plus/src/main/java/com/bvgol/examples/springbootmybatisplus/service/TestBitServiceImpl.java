package com.bvgol.examples.springbootmybatisplus.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.model.TestBit;
import com.bvgol.examples.springbootmybatisplus.mapper.TestBitMapper;
import com.bvgol.examples.springbootmybatisplus.service.TestBitService;
@Service
public class TestBitServiceImpl extends ServiceImpl<TestBitMapper, TestBit> implements TestBitService{

}
