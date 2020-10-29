package com.bvgol.examples.springbootredis.com.utils;

import java.lang.annotation.Annotation;

public interface TypeQualifierValidator<A extends Annotation> {
    @Nonnull
    When forConstantValue(@Nonnull A var1, Object var2);
}
