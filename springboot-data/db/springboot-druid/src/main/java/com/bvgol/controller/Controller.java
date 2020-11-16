package com.bvgol.controller;/**
 * @Classname Controller
 * @Description TODO
 * @Date 2020/11/9 17:01
 * @Created by GUOCHEN
 */

import com.bvgol.pojo.Druid;
import com.bvgol.service.DruidService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: my-springboot-completely
 * @description: web
 * @author: GUOCHEN
 * @create: 2020/11/09 17:01
 */
@RestController
@Data
public class Controller {
    @Autowired
    private DruidService service;

    /**
     * @param id
     * @return druid 对象
     * @Classname Controller
     * @Description TODO
     * @Date 2020/11/9 17:03
     * @auther by GUOCHEN
     */
    @GetMapping("get/{id}")
    public Object get(@PathVariable("id") Integer id) {
        return service.selectByPrimaryKey(id);
    }

    /**
     * @param obj
     * @return obj
     * @Classname Controller
     * @Description TODO
     * @Date 2020/11/9 17:04
     * @auther by GUOCHEN
     */
    @PostMapping("post")
    public Object post(@RequestBody Druid obj) {
        return service.insert(obj);
    }

    /**
     * @param
     * @return
     * @Classname Controller
     * @Description TODO
     * @Date 2020/11/9 17:20
     * @auther by GUOCHEN
     */
    @DeleteMapping("delete/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        return service.deleteByPrimaryKey(id);
    }

    /**
     * @param
     * @return
     * @Classname Controller
     * @Description 故意写错的sql
     * @Date 2020/11/9 17:29
     * @auther by GUOCHEN
     */
    @GetMapping("error/{id}")
    public Object get(@PathVariable("id") String id) {
        return service.error();
    }

}
