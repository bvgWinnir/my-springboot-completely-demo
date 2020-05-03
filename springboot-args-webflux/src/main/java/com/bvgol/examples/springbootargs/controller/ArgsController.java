package com.bvgol.examples.springbootargs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/postString")
    public Object postString(@RequestBody() String obj) {
        return null;
    }

    @PostMapping("/getString/{str}")
    public Object getString(@PathVariable("str") String str ) {
        return str;
    }


    @PostMapping("/xxx/xxx/")
    public Object postObj(@RequestBody() Object obj) {
        return null;
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
