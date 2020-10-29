package com.bvgol.springbootjapiDocs.result;

import java.util.List;

/**
 * @author yeguozhong yedaxia.github.com
 */
public class Result<M, T extends Object> {
    private M message; //消息
    private List<T> list; //列表
}