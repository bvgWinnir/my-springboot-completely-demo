package com.bvgol.examples.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * facade接口注解， 用于统一对facade进行参数校验及异常捕获
 *
 * <pre>
 *
 *      注意，使用该注解需要注意，该方法的返回值必须是BaseResponse的子类
 *
 * </pre>
 */

@Target(ElementType.METHOD)

@Retention(RetentionPolicy.RUNTIME)

public @interface Facade {

}
