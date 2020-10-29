package com.bvgol.examples.springbootredis.com.utils;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    String getMessage();

    int getCode();
}
