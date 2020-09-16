package com.bvgol.examples.springbootargs.controller;

import com.bvgol.examples.springbootargs.vo.DemoVo;
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

    /**
     * ?    1:@RequestParam  2:obj
     * /{}  1:@PathVariable("str") String str
     * from 1:@RequestParam  2:obj
     * json @RequestBody+obj
     */
    @GetMapping("/get")
    public Object get(@RequestParam() String str) {
        return str;
    }

    @GetMapping("/getMore")
    public Object getMore(@RequestParam() Map map) {
        return map;
    }

    @GetMapping("/getString/{str}")
    public Object getString1(@PathVariable("str") String str) {
        return str;
    }

    @GetMapping("/getStringMore/{str}{str2}")
    public Object getString2(@PathVariable("str") String str, @PathVariable("str2") String str2) {
        return str + "--" + str2;
    }

    @PostMapping("/postFrom")
    public Object postMap(@RequestParam String map) {
        return map;
    }

    @PostMapping("/postFromMore")
    public Object postFromMore(Map map) {
        return map;
    }

    @PostMapping("/postJson")
    public Object postJson(@RequestBody String obj) {
        return obj;
    }

    @PostMapping("/postJsonMore")
    public Object postJsonMore(@RequestBody DemoVo vo) {
        return vo;
    }
}
