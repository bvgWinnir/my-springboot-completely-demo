package com.bvgol.examples.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/12/28 17:24
 */
@Controller
public class TestController {
    /**
     * @param
     * @return
     * @Classname TestController
     * @Description TODO
     * @Date 2020/12/28 17:24
     * @auther by GUOCHEN
     */
    @GetMapping("get")
    public Object get(Model model) {
        model.addAttribute("msg", "据说明天有大雪");
        //ViewConstants.USER_MY_CONTACTS
        return "hello1";
    }

    /**
     * @param
     * @return
     * @Classname TestController
     * @Description TODO
     * @Date 2020/12/28 17:31
     * @auther by GUOCHEN
     */
    @GetMapping("getxx")
    public Object getxx(Model model) {
        model.addAttribute("msg", "据说明天有sssssssssss大雪");
        return "xx/iuo";
    }

}
