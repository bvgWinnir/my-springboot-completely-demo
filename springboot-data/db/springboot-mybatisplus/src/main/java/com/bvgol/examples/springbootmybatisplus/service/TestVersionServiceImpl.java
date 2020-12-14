package com.bvgol.examples.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.TestVersionMapper;
import com.bvgol.examples.springbootmybatisplus.model.TestVersion;
import org.springframework.stereotype.Service;
/**
 * @Classname TestVersionServiceImpl
 * @Description TODO
 * @Date 2020/10/27 13:34
 * @Created by GUOCHEN
 */
@Service
public class TestVersionServiceImpl extends ServiceImpl<TestVersionMapper, TestVersion> implements TestVersionService{

}
