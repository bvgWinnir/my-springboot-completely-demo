package com.bvgol.utils;

import java.util.UUID;

public class IdUtil {
    public static String UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
