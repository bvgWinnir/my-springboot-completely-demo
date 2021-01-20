package com.bvgol.examples.myAnnotation.ann;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface ApiOperateLog {
    String logName() default "操作日志";

    String logType();

    String logModule();
}
