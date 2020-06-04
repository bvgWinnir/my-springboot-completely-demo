package com.bvgol.examples.springbootMybatisXmlMultiple.dynamicdatasource;

import java.lang.annotation.*;

/**
 * @author luoping
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSourceSelector {

    DynamicDataSourceEnum value() default DynamicDataSourceEnum.MASTER;

    boolean clear() default true;

}