package com.bvgol.examples.commonExecption.controller;

import com.bvgol.examples.commonExecption.exec.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2720:56
 */
@RestController
@RequestMapping("exception")
public class HelloController {

    @GetMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @GetMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2,自定义异常");
    }

    @GetMapping("/jsonE")
    public String jsonE() throws Exception {
        throw new Exception("发生错误2,自定义异常");
    }


}
