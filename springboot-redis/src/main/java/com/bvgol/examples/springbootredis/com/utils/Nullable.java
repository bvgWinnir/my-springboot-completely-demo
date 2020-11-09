package com.bvgol.examples.springbootredis.com.utils;

import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Nonnull(
    when = When.MAYBE
)
@TypeQualifierNickname
public @interface Nullable {
}
