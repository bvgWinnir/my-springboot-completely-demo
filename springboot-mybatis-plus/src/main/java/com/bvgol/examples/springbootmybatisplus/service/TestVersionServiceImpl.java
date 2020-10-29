package com.bvgol.examples.springbootmybatisplus.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bvgol.examples.springbootmybatisplus.mapper.TestVersionMapper;
import com.bvgol.examples.springbootmybatisplus.model.TestVersion;
import com.bvgol.examples.springbootmybatisplus.service.TestVersionService;
/**
 * @Classname TestVersionServiceImpl
 * @Description TODO
 * @Date 2020/10/27 13:34
 * @Created by GUOCHEN
 */
@Service
public class TestVersionServiceImpl extends ServiceImpl<TestVersionMapper, TestVersion> implements TestVersionService{

}
