package com.bvgol.examples.myAnnotation;/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/11/17 14:29
 * @Created by GUOCHEN
 */

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/17 14:29
 */

@RestController
public class TestController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public HashMap view(@RequestParam(name = "id") String id) throws Exception {
        return null;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public HashMap update(OrderVO orderVo) throws Exception {
        return null;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public  InsertResult insert(OrderVO orderVo) throws Exception {

        return null;

    }

    @GetMapping("")
    public TestResponse query(User user) {
        return null;
    }
}
