package com.bvgol.examples.springbootmybatisplus.mapper;

import lombok.Data;

@Data
public class R {
    public static R error() {
        return null;
    }
    public static R ok(){
        return null;
    }

    public R message(String str) {
        return null;
    }
    private R(){}
    private boolean success;
    private String code;
    private String message;
    private Object Data;
}
