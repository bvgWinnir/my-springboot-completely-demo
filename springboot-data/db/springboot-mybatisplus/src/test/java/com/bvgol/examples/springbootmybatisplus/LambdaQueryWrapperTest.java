package com.bvgol.examples.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * @Classname LambdaQueryWrapperTest
 * @Description TODO
 * @Date 2020/9/27 14:43
 * @Created by GUOCHEN
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaQueryWrapperTest {
    @Test
    void e_1testNestPage() {
        ArrayList<Object> list = new ArrayList<>();
        LambdaQueryWrapper<CommonData> wrapper = Wrappers.<CommonData>lambdaQuery()
                .isNotNull(CommonData::getId).and(i -> i.eq(CommonData::getId, 1)
                        .or().in(CommonData::getTestInt, list));
        System.out.println(wrapper.getSqlSegment());
        System.out.println(wrapper.getSqlSegment());
        System.out.println(wrapper.getSqlSegment());
        System.out.println(wrapper.getSqlSegment());
        System.out.println(wrapper.getSqlSegment());
//        commonMapper.selectList(wrapper);
//        commonMapper.selectPage(new Page<>(1, 10), wrapper);
    }
}
