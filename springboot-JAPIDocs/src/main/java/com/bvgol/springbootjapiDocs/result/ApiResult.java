package com.bvgol.springbootjapiDocs.result;

/**
 * @author guochen
 * @Title: ApiResult
 * @Package
 * @Description:
 * @date 2020/6/289:59
 */

public class ApiResult<T> {
    private Integer code;
    private String errMsg;
    private T data;
}
