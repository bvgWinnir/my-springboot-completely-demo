package com.bvgol.examples.springbootargs.controller;

import com.bvgol.examples.springbootargs.pojo.Demo;
import com.bvgol.examples.springbootargs.vo.DemoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Classname ArgsController
 * @Description TODO
 * @Date 2020/5/3 9:37
 * @Created by guochen
 */
@Slf4j
@RestController("/args")
public class ArgsController {


    @PostMapping("/postMap")
    public Object postMap(@RequestBody() Map map) {
        return map;
    }

    @GetMapping("/getMap")
    public Object getMap(@RequestParam() Map map) {
        return map;
    }

    @PostMapping("/postString")
    public Object postString(@RequestBody String obj) {
        return null;
    }

    @GetMapping("/getString/{str}")
    public Object getString(@PathVariable("str") String str ) {
        return str;
    }


    @PostMapping("/list")
    public Object postObj(@RequestBody DemoVo vo) {
        Demo demo = new Demo();

        return demo;
    }

//    @GetMapping("/xxx/xxx/{xx}")
//    public Object getObj(@RequestParam() Object obj) {
//        return null;
//    }
//
//
//    @PostMapping("/xxx/xxx/")
//    public Object postList(@RequestBody() Object obj) {
//        return null;
//    }
//
//    @GetMapping("/xxx/xxx/{xx}")
//    public Object getList(@RequestParam() Object obj) {
//        return null;
//    }
}
