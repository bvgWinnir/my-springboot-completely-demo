package com.bvgol.examples.springbootredis.com.annotation;/**
 * @Classname AccessLimit
 * @Description TODO
 * @Date 2020/12/8 9:03
 * @Created by GUOCHEN
 */

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @program: my-springboot-completely
 * @description: 防刷注解
 * @author: GUOCHEN
 * @create: 2020/12/08 09:03
 */
@Retention(RUNTIME)

@Target
        (METHOD)

public @interface

AccessLimit {
    int seconds();

    int maxCount();

    boolean needLogin() default true;

}
