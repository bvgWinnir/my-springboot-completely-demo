package com.bvgol.examples.springbootredis.com.controller;/**
 * @Classname FangShuaController
 * @Description TODO
 * @Date 2020/12/8 9:02
 * @Created by GUOCHEN
 * @program: my-springboot-completely
 * @description: 防刷
 * @author: GUOCHEN
 * @create: 2020/12/08 09:02
 * @program: my-springboot-completely
 * @description: 防刷
 * @author: GUOCHEN
 * @create: 2020/12/08 09:02
 * @program: my-springboot-completely
 * @description: 防刷
 * @author: GUOCHEN
 * @create: 2020/12/08 09:02
 * @program: my-springboot-completely
 * @description: 防刷
 * @author: GUOCHEN
 * @create: 2020/12/08 09:02
 */

/**
 * @program: my-springboot-completely
 * @description: 防刷
 * @author: GUOCHEN
 * @create: 2020/12/08 09:02
 */

import com.bvgol.examples.springbootredis.com.annotation.AccessLimit;
import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yhq

 * @date 2018/9/10 15:49

 */

@Controller

public class FangShuaController {
    @AccessLimit(seconds = 5, maxCount = 5, needLogin = true)
    @RequestMapping("/fangshua")
    @ResponseBody
    public Result<String> fangshua() {
        return Result.success("请求成功");
    }
}
