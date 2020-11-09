package com.bvgol.springbootjapiDocs.controller;

import com.bvgol.springbootjapiDocs.result.ApiResult;
import io.github.yedaxia.apidocs.Ignore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 忽略接口
 *
 * @author yeguozhong yedaxia.github.com
 */
@RestController
public class IgnoreController {

    @Ignore
    @GetMapping("/ignore/hello")
    public ApiResult hello() {
        return null;
    }

    public ApiResult hello2() {
        return null;
    }
}
