package com.bvgol.examples.springbootMybatisXmlMultiple.common;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * @Classname MyMapper
 * @Description TODO
 * @Date 2020/6/4 13:45
 * @Created by guochen
 */
@Slf4j



/**
 * @author kevin
 * @date 2019-11-20 10:12
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // TODO
    // FIXME 特别注意，该接口不能被扫描到，否则会出错
}
