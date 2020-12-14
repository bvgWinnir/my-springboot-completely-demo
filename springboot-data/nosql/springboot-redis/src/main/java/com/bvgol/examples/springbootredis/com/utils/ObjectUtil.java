package com.bvgol.examples.springbootredis.com.utils;

import org.springframework.util.ObjectUtils;

public class ObjectUtil extends ObjectUtils {
    public ObjectUtil() {
    }

    public static boolean isNotEmpty(@Nullable Object obj) {
        return !isEmpty(obj);
    }
}